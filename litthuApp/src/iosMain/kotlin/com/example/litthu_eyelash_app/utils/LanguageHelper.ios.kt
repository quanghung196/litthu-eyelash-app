package com.example.litthu_eyelash_app.utils

import platform.Foundation.NSBundle

actual fun getLanguageCode(): String {
    val languageCode = NSBundle.mainBundle.preferredLocalizations.firstOrNull().toString()
    return languageCode.takeIf { it.isNotEmpty() }?.substringBefore("-") ?: "en"
}