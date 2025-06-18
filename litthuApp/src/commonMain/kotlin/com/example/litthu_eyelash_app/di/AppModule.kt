package com.example.litthu_eyelash_app.di

import com.example.litthu_eyelash_app.data.di.dataModule
import com.example.litthu_eyelash_app.domain.di.domainModule
import com.example.litthu_eyelash_app.presentation.di.presentationModule
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

expect val platformModule: Module

fun initKoin(config: KoinAppDeclaration? = null) {
    val commonModule = module {
        includes(
            dataModule,
            domainModule,
            presentationModule,
        )
    }

    val appModule = listOf(
        commonModule,
        platformModule,
    )

    startKoin {
        config?.invoke(this)
        modules(appModule)
    }
}