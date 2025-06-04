package com.example.litthu_eyelash_app.data.remote

import com.example.litthu_eyelash_app.data.local.non_volatile_memory.NonVolatileMemory
import com.example.litthu_eyelash_app.data.remote.core.ApiHelper
import com.example.litthu_eyelash_app.domain.auth.usecase.GetSetAccessTokenUseCase
import io.ktor.client.HttpClient

interface LitthuNetworkProvider {
    val ktor: HttpClient
}

class LitthuNetworkProviderImpl(
    private val nonVolatileMemory: NonVolatileMemory,
) : LitthuNetworkProvider {

    override val ktor: HttpClient
        get() = createHttpClient()

    private fun createHttpClient(): HttpClient {
        val accessToken = nonVolatileMemory.accessToken
        return ApiHelper.createHttpClient(accessToken = accessToken)
    }
}