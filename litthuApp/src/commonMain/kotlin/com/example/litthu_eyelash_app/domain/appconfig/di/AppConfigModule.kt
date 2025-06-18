package com.example.litthu_eyelash_app.domain.appconfig.di

import com.example.litthu_eyelash_app.domain.appconfig.usecase.GetSetAppLanguageUseCase
import com.example.litthu_eyelash_app.domain.appconfig.usecase.GetSetAppLanguageUseCaseImpl
import com.example.litthu_eyelash_app.domain.appconfig.usecase.LanguageConfigUseCase
import com.example.litthu_eyelash_app.domain.appconfig.usecase.LanguageConfigUseCaseImpl
import org.koin.dsl.module

val appConfigModule = module {
    single<GetSetAppLanguageUseCase> {
        GetSetAppLanguageUseCaseImpl(
            appConfigRepository = get(),
        )
    }

    single<LanguageConfigUseCase> {
        LanguageConfigUseCaseImpl(
            getSetAppLanguageUseCase = get(),
        )
    }
}