package com.example.litthu_eyelash_app.data.remote.core

import com.example.litthu_eyelash_app.data.remote.LitthuApiPath
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object ApiHelper {
    fun createHttpClient(accessToken: String? = null): HttpClient {
        return HttpClient {
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
                    host = LitthuApiPath.BASE_URL
                }
            }
            installCustomInterceptor {
                this.accessToken = accessToken
                onUnauthorized = {
                    println("Unauthorized, need to refresh token")
                }
            }
        }
    }
}