package com.example.litthu_eyelash_app.utils

interface Platform {
    val name: String
    val osType: OSType
}

enum class OSType {
    IOS, ANDROID
}

expect fun getPlatform(): Platform
