package com.example.litthu_eyelash_app.presentation.di

import com.example.litthu_eyelash_app.presentation.login.di.loginModule
import org.koin.dsl.module

val presentationModule = module {
    includes(loginModule)
}