package com.example.litthu_eyelash_app.data.model

import kotlinx.serialization.Serializable

@Serializable
open class BaseResponseEntity(
    val result: String? = null,
    val messageID: String? = null,
    val message: String? = null,
)