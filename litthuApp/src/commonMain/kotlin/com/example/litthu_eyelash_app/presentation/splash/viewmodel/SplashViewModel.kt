package com.example.litthu_eyelash_app.presentation.splash.viewmodel

import com.example.litthu_eyelash_app.domain.auth.usecase.GetSetAccessTokenUseCase
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserInfoDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.usecase.GetSetUserInfoUseCase
import com.example.litthu_eyelash_app.presentation.core.BaseViewModel
import kotlinx.coroutines.launch

data class SplashViewState(
    val isLoggedIn: Boolean = false,
    val isConfigLoaded: Boolean = false,
)

class SplashViewModel(
    private val getSetAccessTokenUseCase: GetSetAccessTokenUseCase,
    private val getSetUserInfoUseCase: GetSetUserInfoUseCase,
) : BaseViewModel<SplashViewState>(SplashViewState()) {

    init {
        initializeAppConfig()
    }

    private fun initializeAppConfig() = viewModelScope.launch {
        checkLoginState()
        dispatchState {
            copy(
                isConfigLoaded = true,
                // TODO: delete later
                isLoggedIn = true,
            )
        }
    }

    private fun checkLoginState() {
        val isLogin = getSetAccessTokenUseCase.get().isNotEmpty()
        if (isLogin) {
            getUserInfo()?.let {
                dispatchState {
                    copy(isLoggedIn = true)
                }
            } ?: clearSession()
        }
    }

    private fun getUserInfo(): UserInfoDomainEntity? {
        return getSetUserInfoUseCase.get()
    }

    private fun clearSession() {
        // TODO
    }
}