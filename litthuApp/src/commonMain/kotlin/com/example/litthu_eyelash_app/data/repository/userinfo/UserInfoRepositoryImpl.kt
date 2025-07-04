package com.example.litthu_eyelash_app.data.repository.userinfo

import com.example.litthu_eyelash_app.data.local.non_volatile_memory.NonVolatileMemory
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserInfoDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.repository.UserInfoRepository
import kotlinx.serialization.json.Json

class UserInfoRepositoryImpl(
    private val nonVolatileMemory: NonVolatileMemory,
) : UserInfoRepository {

    override var userInfo: UserInfoDomainEntity?
        get() {
            val userJsonString = nonVolatileMemory.userInfo
            return try {
                Json.decodeFromString<UserInfoDomainEntity>(userJsonString)
            } catch (e: Exception) {
                null
            }
        }
        set(value) {
            val userJsonString = Json.encodeToString(value)
            nonVolatileMemory.userInfo = userJsonString
        }
}