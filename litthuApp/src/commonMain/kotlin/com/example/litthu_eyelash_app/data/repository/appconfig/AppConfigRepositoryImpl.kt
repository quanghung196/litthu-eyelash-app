package com.example.litthu_eyelash_app.data.repository.appconfig

import com.example.litthu_eyelash_app.data.local.non_volatile_memory.NonVolatileMemory
import com.example.litthu_eyelash_app.domain.appconfig.repository.AppConfigRepository

class AppConfigRepositoryImpl(
    private val nonVolatileMemory: NonVolatileMemory,
): AppConfigRepository {

    override var appLanguage: String
        get() = nonVolatileMemory.appLanguage
        set(value) {
            nonVolatileMemory.appLanguage = value
        }
}