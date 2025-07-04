package com.example.litthu_eyelash_app.presentation.auth.di

import com.example.litthu_eyelash_app.presentation.auth.viewmodel.LoginViewModel
import org.koin.dsl.module

val loginModule = module {
    factory {
        LoginViewModel(
            loginUseCase = get(),
        )
    }
}

