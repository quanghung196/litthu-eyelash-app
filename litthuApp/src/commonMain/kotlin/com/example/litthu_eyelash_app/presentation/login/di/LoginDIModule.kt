package com.example.litthu_eyelash_app.presentation.login.di

import com.example.litthu_eyelash_app.presentation.login.viewmodel.LoginViewModel
import org.koin.dsl.module

val loginModule = module {
    factory {
        LoginViewModel(
            loginUseCase = get(),
        )
    }
}

