package com.example.litthu_eyelash_app.data.local.non_volatile_memory

interface NonVolatileMemory {
    var appLanguage: String
    var accessToken: String
    var refreshToken: String
    var userInfo: String

    fun clearAccessToken()
    fun clearToken()
}