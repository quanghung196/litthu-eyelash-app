package com.example.litthu_eyelash_app.domain.userInfo.repository

import com.example.litthu_eyelash_app.domain.userInfo.entity.UserInfoDomainEntity

interface UserInfoRepository {
    var userInfo: UserInfoDomainEntity?
}