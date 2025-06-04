package com.example.litthu_eyelash_app.domain.auth.usecase

import com.example.litthu_eyelash_app.domain.auth.entity.AuthRequestDomainEntity
import com.example.litthu_eyelash_app.domain.auth.repository.AuthRepository
import com.example.litthu_eyelash_app.domain.core.usecase.UseCase

interface LoginUseCase : UseCase<AuthRequestDomainEntity, Unit>

class LoginUseCaseImpl(
    private val authRepository: AuthRepository,
    private val getSetAccessTokenUseCase: GetSetAccessTokenUseCase,
) : LoginUseCase {

    override suspend fun execute(parameters: AuthRequestDomainEntity) {
        val result = authRepository.login(authRequest = parameters)
        getSetAccessTokenUseCase.set(result.accessToken)
    }
}