package com.example.litthu_eyelash_app.data.model

interface BaseResponseEntity {
    val result: String?
    val messageID: String?
    val message: String?

    fun isValidResponse(): Boolean {
        return checkBoundaryValue()
    }

    fun checkBoundaryValue(): Boolean {
        return true
    }
}