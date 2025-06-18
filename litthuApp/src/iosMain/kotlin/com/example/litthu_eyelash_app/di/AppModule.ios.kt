package com.example.litthu_eyelash_app.di

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.core.module.Module
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

actual val platformModule: Module
    get() = module {
        single<Settings> {
            NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults)
        }
    }