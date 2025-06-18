package com.example.litthu_eyelash_app.domain.auth.usecase

import com.example.litthu_eyelash_app.domain.auth.repository.AuthRepository
import com.example.litthu_eyelash_app.domain.core.usecase.GetSetUseCase

interface GetSetRefreshTokenUseCase : GetSetUseCase<String>

class GetSetRefreshTokenUseCaseImpl(
    private val authRepository: AuthRepository,
) : GetSetRefreshTokenUseCase {
    override fun set(params: String) {
        authRepository.refreshToken = params
    }

    override fun get(): String {
        return authRepository.refreshToken
    }
}