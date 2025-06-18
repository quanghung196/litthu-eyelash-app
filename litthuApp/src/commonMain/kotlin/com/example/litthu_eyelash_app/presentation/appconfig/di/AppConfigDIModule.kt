package com.example.litthu_eyelash_app.presentation.appconfig.di

import com.example.litthu_eyelash_app.presentation.appconfig.viewmodel.AppConfigViewModel
import org.koin.dsl.module

val appConfigModule = module {
    single {
        AppConfigViewModel(
            getSetAppLanguageUseCase = get(),
        )
    }
}