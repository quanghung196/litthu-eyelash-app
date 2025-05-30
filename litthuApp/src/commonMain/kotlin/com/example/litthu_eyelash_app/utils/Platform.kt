package com.example.litthu_eyelash_app.utils

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
