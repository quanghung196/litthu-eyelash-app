package com.example.litthu_eyelash_app.domain.auth.entity

import com.example.litthu_eyelash_app.domain.core.model.BaseResponseDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserInfoDomainEntity
import com.example.litthu_eyelash_app.utils.Constants

data class AuthResponseDomainEntity(
    val accessToken: String = Constants.EMPTY,
    val refreshToken: String = Constants.EMPTY,
    val userInfo: UserInfoDomainEntity? = null,

    override var result: String = Constants.EMPTY,
    override var messageID: String = Constants.EMPTY,
    override var message: String = Constants.EMPTY,
) : BaseResponseDomainEntity