package com.example.litthu_eyelash_app.domain.userInfo.di

import com.example.litthu_eyelash_app.domain.userInfo.usecase.GetSetUserInfoUseCase
import com.example.litthu_eyelash_app.domain.userInfo.usecase.GetSetUserInfoUseCaseImpl
import org.koin.dsl.module

val userInfoModule = module {
    single<GetSetUserInfoUseCase> {
        GetSetUserInfoUseCaseImpl(
            userInfoRepository = get(),
        )
    }
}