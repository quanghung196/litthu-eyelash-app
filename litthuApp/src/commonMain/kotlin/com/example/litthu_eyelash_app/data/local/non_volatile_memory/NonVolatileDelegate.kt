package com.example.litthu_eyelash_app.data.local.non_volatile_memory

import com.example.litthu_eyelash_app.utils.Constants
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringPreferenceDelegate(
    private val settings: Settings,
    private val key: String,
    private val defaultValue: String = Constants.EMPTY,
) : ReadWriteProperty<Any, String> {
    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return settings.getString(key = key, defaultValue = defaultValue)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        settings.set(key = key, value = value)
    }
}