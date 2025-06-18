package com.example.litthu_eyelash_app.domain.core.usecase

interface GetSetUseCase<P> {
    fun set(params: P)
    fun get(): P
}