package com.example.litthu_eyelash_app.data.repository.auth

import com.example.litthu_eyelash_app.data.local.non_volatile_memory.NonVolatileMemory
import com.example.litthu_eyelash_app.data.remote.LitthuApiServiceImpl
import com.example.litthu_eyelash_app.domain.auth.entity.AuthRequestDomainEntity
import com.example.litthu_eyelash_app.domain.auth.entity.AuthResponseDomainEntity
import com.example.litthu_eyelash_app.domain.auth.repository.AuthRepository

class AuthRepositoryImpl(
    private val apiService: LitthuApiServiceImpl,
    private val nonVolatileMemory: NonVolatileMemory,
) : AuthRepository {

    override var accessToken: String
        get() = nonVolatileMemory.accessToken
        set(value) {
            nonVolatileMemory.accessToken = value
        }

    override suspend fun login(authRequest: AuthRequestDomainEntity): AuthResponseDomainEntity {
        return apiService.login(authRequest = authRequest).toDomain()
    }
}