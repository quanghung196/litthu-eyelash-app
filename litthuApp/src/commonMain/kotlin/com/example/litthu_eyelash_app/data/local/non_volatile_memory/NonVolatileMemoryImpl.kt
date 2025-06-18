package com.example.litthu_eyelash_app.data.local.non_volatile_memory

import com.russhwolf.settings.Settings

class NonVolatileMemoryImpl(
    private val settings: Settings,
) : NonVolatileMemory {

    override var appLanguage: String by StringPreferenceDelegate(
        settings = settings,
        key = NonVolatileKey.APP_LANGUAGE,
        defaultValue = ""
    )

    override var accessToken: String by StringPreferenceDelegate(
        settings = settings,
        key = NonVolatileKey.ACCESS_TOKEN,
        defaultValue = ""
    )

    override var refreshToken: String by StringPreferenceDelegate(
        settings = settings,
        key = NonVolatileKey.REFRESH_TOKEN,
        defaultValue = ""
    )

    override fun clearAccessToken() {
        settings.remove(NonVolatileKey.ACCESS_TOKEN)
    }

    override fun clearToken() {
        settings.apply {
            remove(NonVolatileKey.ACCESS_TOKEN)
            remove(NonVolatileKey.REFRESH_TOKEN)
        }
    }
}