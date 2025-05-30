package com.example.litthu_eyelash_app.data.remote

import com.example.litthu_eyelash_app.data.remote.core.ApiHelper
import io.ktor.client.HttpClient

interface LitthuNetworkProvider {
    val ktor: HttpClient
}

class LitthuNetworkProviderImpl : LitthuNetworkProvider {

    override val ktor: HttpClient
        get() = createHttpClient()

    private fun createHttpClient(): HttpClient {
        return ApiHelper.createHttpClient()
    }
}