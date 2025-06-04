package com.example.litthu_eyelash_app.domain.core.di

import com.example.litthu_eyelash_app.domain.auth.di.authModule
import org.koin.dsl.module

val domainModule = module {
    includes(
        authModule,
    )
}