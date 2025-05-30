package com.example.litthu_eyelash_app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType

class LitthuApiService(private val client: HttpClient) {

    suspend fun login(email: String, password: String) {
        return client.post("https://api.example.com/login") {
            contentType(ContentType.Application.Json)
            //setBody(LoginRequest(email, password))
        }.body()
    }
}