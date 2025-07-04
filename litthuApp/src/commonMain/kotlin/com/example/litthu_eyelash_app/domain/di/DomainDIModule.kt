package com.example.litthu_eyelash_app.domain.di

import com.example.litthu_eyelash_app.domain.appconfig.di.appConfigModule
import com.example.litthu_eyelash_app.domain.auth.di.authModule
import com.example.litthu_eyelash_app.domain.userInfo.di.userInfoModule
import org.koin.dsl.module

val domainModule = module {
    includes(
        appConfigModule,
        authModule,
        userInfoModule,
    )
}