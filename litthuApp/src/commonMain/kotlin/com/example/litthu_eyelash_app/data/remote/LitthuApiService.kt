package com.example.litthu_eyelash_app.data.remote

import com.example.litthu_eyelash_app.data.model.auth.AuthResponseEntity
import com.example.litthu_eyelash_app.domain.auth.entity.AuthRequestDomainEntity

interface LitthuApiService {

    suspend fun login(authRequest: AuthRequestDomainEntity): AuthResponseEntity
}