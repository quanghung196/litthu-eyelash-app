package com.example.litthu_eyelash_app.domain.auth.di

import com.example.litthu_eyelash_app.domain.auth.usecase.GetSetAccessTokenUseCase
import com.example.litthu_eyelash_app.domain.auth.usecase.GetSetAccessTokenUseCaseImpl
import com.example.litthu_eyelash_app.domain.auth.usecase.LoginUseCase
import com.example.litthu_eyelash_app.domain.auth.usecase.LoginUseCaseImpl
import org.koin.dsl.module

val authModule = module {
    single<GetSetAccessTokenUseCase> {
        GetSetAccessTokenUseCaseImpl(
            authRepository = get(),
        )
    }

    single<LoginUseCase> {
        LoginUseCaseImpl(
            authRepository = get(),
            getSetAccessTokenUseCase = get(),
        )
    }
}