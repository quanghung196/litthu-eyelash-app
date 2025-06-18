package com.example.litthu_eyelash_app.data.remote

import com.example.litthu_eyelash_app.data.model.BaseResponseEntity
import com.example.litthu_eyelash_app.domain.auth.repository.AuthRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class SafeCallApi(
    private val authRepository: AuthRepository,
) {
    sealed class AuthState {
        data object Idle : AuthState()
        data object RefreshingToken : AuthState()
        data object TokenRefreshed : AuthState()
        data object RefreshFailed : AuthState()
    }

    private val refreshMutex = Mutex()
    private var currentAuthState: AuthState = AuthState.Idle

    data class PendingRequest(
        val request: suspend () -> BaseResponseEntity,
        val continuation: Continuation<BaseResponseEntity>
    )

    private val pendingRequests = mutableListOf<PendingRequest>()

    suspend fun <T : BaseResponseEntity> executeWithAuth(request: suspend () -> T): T {
        return try {
            request.invoke()
        } catch (e: Exception) {
            if (e is LitthuNetworkError.UnauthorizedException) {
                handleUnauthorized(request = request)
            }
            throw e
        }
    }

    private suspend fun <T : BaseResponseEntity> handleUnauthorized(
        request: suspend () -> T
    ): BaseResponseEntity {
        return refreshMutex.withLock {
            when (currentAuthState) {
                AuthState.Idle -> {
                    suspendCoroutine { continuation ->
                        pendingRequests.add(PendingRequest(request, continuation))

                        CoroutineScope(Dispatchers.IO).launch {
                            startTokenRefresh()
                        }
                    }
                }

                AuthState.RefreshingToken -> {
                    waitForRefreshAndRetry(request)
                }

                AuthState.TokenRefreshed -> {
                    currentAuthState = AuthState.Idle
                    request()
                }

                AuthState.RefreshFailed -> {
                    logout()
                    throw LitthuNetworkError.UnauthorizedException
                }
            }
        }
    }

    private suspend fun startTokenRefresh() {
        currentAuthState = AuthState.RefreshingToken

        val refreshToken = authRepository.refreshToken
        try {
            authRepository.apply {
                clearAccessToken()
                refreshToken(refreshToken = refreshToken).let {
                    authRepository.accessToken = it.accessToken
                    authRepository.refreshToken = it.refreshToken
                }
            }
            currentAuthState = AuthState.TokenRefreshed
            retryPendingRequests()
        } catch (e: Exception) {
            currentAuthState = AuthState.RefreshFailed
            failPendingRequests()
        }
    }

    private suspend fun <T : BaseResponseEntity> waitForRefreshAndRetry(
        request: suspend () -> T
    ): BaseResponseEntity {
        return suspendCoroutine { continuation ->
            pendingRequests.add(
                PendingRequest(
                    request = request,
                    continuation = continuation
                )
            )
        }
    }

    private suspend fun retryPendingRequests() {
        pendingRequests.forEach { pendingRequest ->
            try {
                val result = pendingRequest.request()
                pendingRequest.continuation.resume(result)
            } catch (e: Exception) {
                pendingRequest.continuation.resumeWithException(e)
            }
        }
        pendingRequests.clear()
    }

    private fun failPendingRequests() {
        pendingRequests.forEach { pendingRequest ->
            pendingRequest.continuation.resumeWithException(
                LitthuNetworkError.UnauthorizedException
            )
        }
        pendingRequests.clear()
    }

    private suspend fun logout() {
        authRepository.clearToken()
        currentAuthState = AuthState.Idle
        pendingRequests.clear()
    }
}