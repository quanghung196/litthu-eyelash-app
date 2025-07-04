package com.example.litthu_eyelash_app.domain.auth.usecase

import com.example.litthu_eyelash_app.domain.auth.entity.AuthRequestDomainEntity
import com.example.litthu_eyelash_app.domain.auth.entity.AuthResponseDomainEntity
import com.example.litthu_eyelash_app.domain.auth.repository.AuthRepository
import com.example.litthu_eyelash_app.domain.core.usecase.UseCase
import com.example.litthu_eyelash_app.domain.userInfo.usecase.GetSetUserInfoUseCase

interface LoginUseCase : UseCase<AuthRequestDomainEntity, AuthResponseDomainEntity>

class LoginUseCaseImpl(
    private val authRepository: AuthRepository,
    private val getSetAccessTokenUseCase: GetSetAccessTokenUseCase,
    private val getSetRefreshTokenUseCase: GetSetRefreshTokenUseCase,
    private val getSetUserInfoUseCase: GetSetUserInfoUseCase,
) : LoginUseCase {

    override suspend fun execute(parameters: AuthRequestDomainEntity): AuthResponseDomainEntity {
        return authRepository.login(authRequest = parameters).also {
            getSetAccessTokenUseCase.set(it.accessToken)
            getSetRefreshTokenUseCase.set(it.refreshToken)
            getSetUserInfoUseCase.set(it.userInfo)
        }
    }
}