package com.example.litthu_eyelash_app.data.repository.di

import com.example.litthu_eyelash_app.data.repository.appconfig.AppConfigRepositoryImpl
import com.example.litthu_eyelash_app.data.repository.auth.AuthRepositoryImpl
import com.example.litthu_eyelash_app.data.repository.userinfo.UserInfoRepositoryImpl
import com.example.litthu_eyelash_app.domain.appconfig.repository.AppConfigRepository
import com.example.litthu_eyelash_app.domain.auth.repository.AuthRepository
import com.example.litthu_eyelash_app.domain.userInfo.repository.UserInfoRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AppConfigRepository> {
        AppConfigRepositoryImpl(
            nonVolatileMemory = get(),
        )
    }

    single<AuthRepository> {
        AuthRepositoryImpl(
            apiService = get(),
            nonVolatileMemory = get(),
        )
    }

    single<UserInfoRepository> {
        UserInfoRepositoryImpl(
            nonVolatileMemory = get(),
        )
    }
}