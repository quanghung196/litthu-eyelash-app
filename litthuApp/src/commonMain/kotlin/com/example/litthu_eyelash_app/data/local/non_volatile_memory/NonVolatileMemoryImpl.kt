package com.example.litthu_eyelash_app.data.local.non_volatile_memory

import com.russhwolf.settings.Settings

class NonVolatileMemoryImpl(
    settings: Settings,
): NonVolatileMemory {

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
}