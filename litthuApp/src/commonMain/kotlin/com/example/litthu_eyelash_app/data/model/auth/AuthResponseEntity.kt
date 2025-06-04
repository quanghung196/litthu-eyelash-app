package com.example.litthu_eyelash_app.data.model.auth

import com.example.litthu_eyelash_app.data.model.BaseResponseEntity
import com.example.litthu_eyelash_app.domain.auth.entity.AuthResponseDomainEntity
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponseEntity(
    val accessToken: String,
    val refreshToken: String,
) : BaseResponseEntity<AuthResponseDomainEntity>() {

    override fun toDomain(): AuthResponseDomainEntity {
        return AuthResponseDomainEntity(
            accessToken = accessToken,
            refreshToken = refreshToken,
            result = result.orEmpty(),
            message = message.orEmpty(),
            messageID = messageID.orEmpty()
        )
    }
}