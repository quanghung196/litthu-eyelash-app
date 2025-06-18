package com.example.litthu_eyelash_app.domain.auth.repository

import com.example.litthu_eyelash_app.domain.auth.entity.AuthRequestDomainEntity
import com.example.litthu_eyelash_app.domain.auth.entity.AuthResponseDomainEntity

interface AuthRepository {

    var accessToken: String

    var refreshToken: String

    suspend fun clearAccessToken()

    suspend fun clearToken()

    suspend fun login(authRequest: AuthRequestDomainEntity): AuthResponseDomainEntity

    suspend fun refreshToken(refreshToken: String): AuthResponseDomainEntity
}