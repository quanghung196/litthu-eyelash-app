package com.example.litthu_eyelash_app.presentation.appconfig.model

enum class AppLanguage(val value: String) {
    VIETNAMESE("vi"),
    ENGLISH("en");

    companion object {
        fun fromValue(value: String): AppLanguage =
            entries.firstOrNull { it.value == value }
                ?: ENGLISH.also {
                    println("Invalid AppLanguage value: $value, load default language as ENGLISH")
                }
    }
}