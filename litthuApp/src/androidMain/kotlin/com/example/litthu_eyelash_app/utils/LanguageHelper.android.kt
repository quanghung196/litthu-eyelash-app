package com.example.litthu_eyelash_app.utils

import java.util.Locale

actual fun getLanguageCode(): String {
    return Locale.getDefault().language
}