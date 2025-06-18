package com.example.litthu_eyelash_app.data.remote.core

import com.example.litthu_eyelash_app.data.remote.LitthuApiConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

expect fun provideHttpClientEngine(): HttpClientEngine

object ApiHelper {
    fun createHttpClient(accessToken: String? = null): HttpClient {
        return HttpClient(provideHttpClientEngine()) {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTP
                    host = LitthuApiConfig.BASE_URL
                    port = LitthuApiConfig.BASE_PORT
                }
                contentType(ContentType.Application.Json)
            }
            install(HttpTimeout) {
                connectTimeoutMillis = LitthuApiConfig.Timeout.CONNECT_TIMEOUT
                socketTimeoutMillis = LitthuApiConfig.Timeout.SOCKET_TIMEOUT
                requestTimeoutMillis = LitthuApiConfig.Timeout.REQUEST_TIMEOUT
            }
            installCustomInterceptor {
                this.accessToken = accessToken
            }
        }
    }
}