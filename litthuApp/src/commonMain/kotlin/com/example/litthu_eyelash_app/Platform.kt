package com.example.litthu_eyelash_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform