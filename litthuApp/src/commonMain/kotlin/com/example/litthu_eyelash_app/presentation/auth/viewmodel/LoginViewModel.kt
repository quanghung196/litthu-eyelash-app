package com.example.litthu_eyelash_app.presentation.auth.viewmodel

import com.example.litthu_eyelash_app.domain.auth.entity.AuthRequestDomainEntity
import com.example.litthu_eyelash_app.domain.auth.usecase.LoginUseCase
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserInfoDomainEntity
import com.example.litthu_eyelash_app.presentation.core.BaseViewModel
import com.example.litthu_eyelash_app.presentation.core.LoadingState
import kotlinx.coroutines.launch

data class LoginViewState(
    val loadingState: LoadingState = LoadingState.HIDE_LOADING,
    val isLoginSuccess: Boolean = false,
    val loginException: Exception? = null,
    val userInfoDomainEntity: UserInfoDomainEntity? = null,
)

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
) : BaseViewModel<LoginViewState>(LoginViewState()) {


    fun login(
        phoneNumber: String,
        password: String,
    ) = viewModelScope.launch {
        dispatchState {
            copy(
                loadingState = LoadingState.SHOW_LOADING,
            )
        }
        loginUseCase.invoke(
            AuthRequestDomainEntity(
                phoneNumber = phoneNumber,
                password = password,
            )
        ).onSuccess {
            it.userInfo?.let {
                dispatchState {
                    copy(
                        loadingState = LoadingState.HIDE_LOADING,
                        isLoginSuccess = true,
                        userInfoDomainEntity = it,
                    )
                }
            }
        }.onFailure {
            dispatchState {
                copy(
                    loadingState = LoadingState.HIDE_LOADING,
                    loginException = it as? Exception,
                )
            }
        }
    }
}