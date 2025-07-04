package com.example.litthu_eyelash_app.presentation.splash.di

import com.example.litthu_eyelash_app.presentation.splash.viewmodel.SplashViewModel
import org.koin.dsl.module

val splashModule = module {
    single {
        SplashViewModel(
            getSetAccessTokenUseCase = get(),
            getSetUserInfoUseCase = get(),
        )
    }
}