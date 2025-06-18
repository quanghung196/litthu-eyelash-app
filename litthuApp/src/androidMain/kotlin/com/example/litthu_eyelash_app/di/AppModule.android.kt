package com.example.litthu_eyelash_app.di

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<Settings> {
            SharedPreferencesSettings(
                get<Context>().getSharedPreferences("litthu", Context.MODE_PRIVATE)
            )
        }
    }