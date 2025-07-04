package com.example.litthu_eyelash_app.presentation.main.di

import com.example.litthu_eyelash_app.presentation.main.viewmodel.MainViewModel
import org.koin.dsl.module

val mainModule = module {
    factory {
        MainViewModel(
            getSetUserInfoUseCase = get(),
        )
    }
}