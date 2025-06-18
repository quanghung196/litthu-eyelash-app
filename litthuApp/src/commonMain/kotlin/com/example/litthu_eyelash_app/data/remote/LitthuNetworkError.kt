package com.example.litthu_eyelash_app.data.remote

import com.example.litthu_eyelash_app.data.model.BaseResponseEntity

sealed class LitthuNetworkError : Exception() {
    data object ConnectionTimeoutException : LitthuNetworkError()
    data object UnauthorizedException : LitthuNetworkError()
    data object ServerErrorException : LitthuNetworkError()
    data object UnknownException : LitthuNetworkError()
    data class LitthuErrorException(
        val errorResponse: BaseResponseEntity,
    ) : LitthuNetworkError()
}