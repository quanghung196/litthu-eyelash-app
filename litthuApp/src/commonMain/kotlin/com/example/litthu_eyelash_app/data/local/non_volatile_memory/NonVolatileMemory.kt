package com.example.litthu_eyelash_app.data.local.non_volatile_memory

import com.russhwolf.settings.Settings

interface NonVolatileMemory {

    var accessToken: String
}

class NonVolatileMemoryImpl(
    private val settings: Settings,
): NonVolatileMemory {

    override var accessToken: String by StringPreferenceDelegate(
        settings = settings,
        key = NonVolatileKey.ACCESS_TOKEN,
        defaultValue = ""
    )
}