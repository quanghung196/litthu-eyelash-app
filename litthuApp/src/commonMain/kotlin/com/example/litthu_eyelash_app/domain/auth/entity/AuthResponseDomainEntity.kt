package com.example.litthu_eyelash_app.domain.auth.entity

import com.example.litthu_eyelash_app.domain.core.model.BaseResponseDomainEntity

data class AuthResponseDomainEntity(
    val accessToken: String,
    val refreshToken: String,

    override var result: String,
    override var messageID: String,
    override var message: String,
) : BaseResponseDomainEntity