package com.example.litthu_eyelash_app.domain.auth.usecase

import com.example.litthu_eyelash_app.domain.auth.repository.AuthRepository
import com.example.litthu_eyelash_app.domain.core.usecase.GetSetUseCase

interface GetSetAccessTokenUseCase : GetSetUseCase<String>

class GetSetAccessTokenUseCaseImpl(
    private val authRepository: AuthRepository,
) : GetSetAccessTokenUseCase {
    override fun set(params: String) {
        authRepository.accessToken = params
    }

    override fun get(): String {
        return authRepository.accessToken
    }
}