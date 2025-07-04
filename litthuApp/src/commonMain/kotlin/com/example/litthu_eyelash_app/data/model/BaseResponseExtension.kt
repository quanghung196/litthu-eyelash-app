package com.example.litthu_eyelash_app.data.model

interface BaseResponseExtension<T> {
    fun toDomain(): T
}