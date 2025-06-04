package com.example.litthu_eyelash_app.data.remote

import com.example.litthu_eyelash_app.data.model.auth.AuthResponseEntity
import com.example.litthu_eyelash_app.domain.auth.entity.AuthRequestDomainEntity
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody

class LitthuApiServiceImpl(
    private val networkProvider: LitthuNetworkProvider
): LitthuApiService {

    private val client: HttpClient
        get() = networkProvider.ktor

    override suspend fun login(authRequest: AuthRequestDomainEntity): AuthResponseEntity {
        return client.post(LitthuApiPath.Auth.AUTH004) {
            setBody(authRequest)
        }.body()
    }
}