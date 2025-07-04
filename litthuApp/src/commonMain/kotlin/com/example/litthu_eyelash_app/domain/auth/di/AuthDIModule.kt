package com.example.litthu_eyelash_app.domain.auth.di

import com.example.litthu_eyelash_app.domain.auth.usecase.GetSetAccessTokenUseCase
import com.example.litthu_eyelash_app.domain.auth.usecase.GetSetAccessTokenUseCaseImpl
import com.example.litthu_eyelash_app.domain.auth.usecase.GetSetRefreshTokenUseCase
import com.example.litthu_eyelash_app.domain.auth.usecase.GetSetRefreshTokenUseCaseImpl
import com.example.litthu_eyelash_app.domain.auth.usecase.LoginUseCase
import com.example.litthu_eyelash_app.domain.auth.usecase.LoginUseCaseImpl
import org.koin.dsl.module

val authModule = module {
    single<GetSetAccessTokenUseCase> {
        GetSetAccessTokenUseCaseImpl(
            authRepository = get(),
        )
    }

    single<GetSetRefreshTokenUseCase> {
        GetSetRefreshTokenUseCaseImpl(
            authRepository = get(),
        )
    }

    single<LoginUseCase> {
        LoginUseCaseImpl(
            authRepository = get(),
            getSetAccessTokenUseCase = get(),
            getSetRefreshTokenUseCase = get(),
            getSetUserInfoUseCase = get(),
        )
    }
}