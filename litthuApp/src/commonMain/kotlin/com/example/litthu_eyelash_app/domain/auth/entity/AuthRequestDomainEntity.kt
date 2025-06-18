package com.example.litthu_eyelash_app.domain.auth.entity

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequestDomainEntity(
    val phoneNumber: String,
    val password: String,
)