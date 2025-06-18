package com.example.litthu_eyelash_app.presentation.splash.viewmodel

import com.example.litthu_eyelash_app.domain.auth.usecase.GetSetAccessTokenUseCase
import com.example.litthu_eyelash_app.presentation.core.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class SplashViewState(
    val isLogin: Boolean = false,
    val isConfigLoaded: Boolean = false,
)

class SplashViewModel(
    private val getSetAccessTokenUseCase: GetSetAccessTokenUseCase,
) : BaseViewModel<SplashViewState>(SplashViewState()) {

    init {
        initializeAppConfig()
    }

    private fun initializeAppConfig() = viewModelScope.launch {
        checkLoginState()
        delay(3000)
        dispatchState {
            copy(isConfigLoaded = true)
        }
    }

    private fun checkLoginState() {
        val isLogin = getSetAccessTokenUseCase.get().isNotEmpty()
        dispatchState {
            copy(isLogin = isLogin)
        }
    }
}