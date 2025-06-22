package com.example.litthu_eyelash_app.data.model.auth

import com.example.litthu_eyelash_app.data.model.BaseResponseEntity
import com.example.litthu_eyelash_app.data.model.BaseResponseExtension
import com.example.litthu_eyelash_app.domain.auth.entity.AuthResponseDomainEntity
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponseEntity(
    val accessToken: String? = null,
    val refreshToken: String? = null,
    override val result: String?,
    override val messageID: String?,
    override val message: String?,
) : BaseResponseEntity, BaseResponseExtension<AuthResponseDomainEntity> {

    override fun toDomain(): AuthResponseDomainEntity {
        return AuthResponseDomainEntity(
            accessToken = accessToken.orEmpty(),
            refreshToken = refreshToken.orEmpty(),
            result = result.orEmpty(),
            message = message.orEmpty(),
            messageID = messageID.orEmpty()
        )
    }

    override fun checkBoundaryValue(): Boolean {
        return accessToken.isNullOrEmpty().not() &&
                refreshToken.isNullOrEmpty().not()
    }
}