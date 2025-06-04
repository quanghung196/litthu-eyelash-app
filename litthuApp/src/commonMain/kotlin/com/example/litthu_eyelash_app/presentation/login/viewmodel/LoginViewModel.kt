package com.example.litthu_eyelash_app.presentation.login.viewmodel

import com.example.litthu_eyelash_app.domain.auth.entity.AuthRequestDomainEntity
import com.example.litthu_eyelash_app.domain.auth.usecase.LoginUseCase
import com.example.litthu_eyelash_app.presentation.core.BaseViewModel
import kotlinx.coroutines.launch

data class LoginViewState(
    val helloText: String? = "Hello BQH"
)

class LoginViewModel(
    private val loginUseCase: LoginUseCase,
) : BaseViewModel<LoginViewState>(LoginViewState()) {

    init {
        viewModelScope.launch {
            loginUseCase.invoke(AuthRequestDomainEntity("0903261998", "456123o451i"))
        }
    }
}