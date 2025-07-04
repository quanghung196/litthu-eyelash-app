package com.example.litthu_eyelash_app.domain.userInfo.entity

import com.example.litthu_eyelash_app.domain.core.model.BaseResponseDomainEntity
import com.example.litthu_eyelash_app.utils.Constants
import kotlinx.serialization.Serializable

data class ListStaffDomainEntity(
    override var result: String,
    override var messageID: String,
    override var message: String,
    val staffList: List<StaffDomainEntity>? = null,
) : BaseResponseDomainEntity

@Serializable
data class StaffDomainEntity(
    val id: Int = 0,
    val name: String = Constants.EMPTY,
    val isActive: Boolean = true,
    val phoneNumber: String = Constants.EMPTY,
    val level: StaffLevelDomainEntity? = null,
)