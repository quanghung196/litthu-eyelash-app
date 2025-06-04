package com.example.litthu_eyelash_app.data.model

import com.example.litthu_eyelash_app.domain.core.model.BaseResponseDomainEntity
import kotlinx.serialization.Serializable

@Serializable
abstract class BaseResponseEntity<T : BaseResponseDomainEntity> {

    var result: String? = null
    var messageID: String? = null
    var message: String? = null

    abstract fun toDomain(): T
}