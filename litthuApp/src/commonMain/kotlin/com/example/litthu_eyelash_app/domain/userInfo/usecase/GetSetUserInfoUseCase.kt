package com.example.litthu_eyelash_app.domain.userInfo.usecase

import com.example.litthu_eyelash_app.domain.core.usecase.GetSetUseCase
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserInfoDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.repository.UserInfoRepository

interface GetSetUserInfoUseCase : GetSetUseCase<UserInfoDomainEntity?>

class GetSetUserInfoUseCaseImpl(
    private val userInfoRepository: UserInfoRepository
) : GetSetUserInfoUseCase {

    override fun set(params: UserInfoDomainEntity?) {
        userInfoRepository.userInfo = params
    }

    override fun get(): UserInfoDomainEntity? {
        return userInfoRepository.userInfo
    }
}