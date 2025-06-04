package com.example.litthu_eyelash_app.domain.auth.repository

import com.example.litthu_eyelash_app.domain.auth.entity.AuthRequestDomainEntity
import com.example.litthu_eyelash_app.domain.auth.entity.AuthResponseDomainEntity

interface AuthRepository {

    var accessToken: String

    suspend fun login(authRequest: AuthRequestDomainEntity): AuthResponseDomainEntity
}