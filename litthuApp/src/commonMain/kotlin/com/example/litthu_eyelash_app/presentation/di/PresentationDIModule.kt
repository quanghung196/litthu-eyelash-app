package com.example.litthu_eyelash_app.presentation.di

import com.example.litthu_eyelash_app.presentation.appconfig.di.appConfigModule
import com.example.litthu_eyelash_app.presentation.login.di.loginModule
import com.example.litthu_eyelash_app.presentation.splash.di.splashModule
import org.koin.dsl.module

val presentationModule = module {
    includes(
        appConfigModule,
        loginModule,
        splashModule,
    )
}