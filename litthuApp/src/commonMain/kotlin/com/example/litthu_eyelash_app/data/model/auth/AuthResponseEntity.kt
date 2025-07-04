package com.example.litthu_eyelash_app.data.model.auth

import com.example.litthu_eyelash_app.data.model.BaseResponseEntity
import com.example.litthu_eyelash_app.data.model.BaseResponseExtension
import com.example.litthu_eyelash_app.data.model.user.UserInfoResponseEntity
import com.example.litthu_eyelash_app.domain.auth.entity.AuthResponseDomainEntity
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponseEntity(
    val accessToken: String? = null,
    val refreshToken: String? = null,
    val userInfo: UserInfoResponseEntity? = null,
    override val result: String? = null,
    override val messageID: String? = null,
    override val message: String? = null,
) : BaseResponseEntity, BaseResponseExtension<AuthResponseDomainEntity> {

    override fun toDomain(): AuthResponseDomainEntity {
        return AuthResponseDomainEntity(
            accessToken = accessToken.orEmpty(),
            refreshToken = refreshToken.orEmpty(),
            result = result.orEmpty(),
            message = message.orEmpty(),
            messageID = messageID.orEmpty(),
            userInfo = userInfo?.toDomain(),
        )
    }

    override fun checkBoundaryValue(): Boolean {
        return accessToken.isNullOrEmpty().not() &&
                refreshToken.isNullOrEmpty().not() &&
                checkValidUserResponse()
    }

    private fun checkValidUserResponse(): Boolean {
        return userInfo?.checkValidUserInfo() ?: false
    }
}