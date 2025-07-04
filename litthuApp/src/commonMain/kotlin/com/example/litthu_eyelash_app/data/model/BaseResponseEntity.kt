package com.example.litthu_eyelash_app.data.model

interface BaseResponseEntity {
    val result: String?
    val messageID: String?
    val message: String?

    fun isValidResponse(): Boolean {
        return checkBoundaryValue() && isResponseSuccess()
    }

    fun checkBoundaryValue(): Boolean {
        return true
    }

    fun isResponseSuccess(): Boolean {
        return result == RESULT_OK
    }

    companion object {
        private const val RESULT_OK = "OK"
    }
}