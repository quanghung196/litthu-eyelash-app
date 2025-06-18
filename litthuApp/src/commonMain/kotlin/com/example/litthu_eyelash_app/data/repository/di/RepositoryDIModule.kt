package com.example.litthu_eyelash_app.data.repository.di

import com.example.litthu_eyelash_app.data.repository.appconfig.AppConfigRepositoryImpl
import com.example.litthu_eyelash_app.data.repository.auth.AuthRepositoryImpl
import com.example.litthu_eyelash_app.domain.appconfig.repository.AppConfigRepository
import com.example.litthu_eyelash_app.domain.auth.repository.AuthRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepository> {
        AuthRepositoryImpl(
            apiService = get(),
            nonVolatileMemory = get(),
        )
    }

    single<AppConfigRepository> {
        AppConfigRepositoryImpl(
            nonVolatileMemory = get(),
        )
    }
}