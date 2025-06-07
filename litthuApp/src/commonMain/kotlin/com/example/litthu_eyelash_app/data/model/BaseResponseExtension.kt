package com.example.litthu_eyelash_app.data.model

import com.example.litthu_eyelash_app.domain.core.model.BaseResponseDomainEntity

interface BaseResponseExtension<T : BaseResponseDomainEntity> {
    fun toDomain(): T
}