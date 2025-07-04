package com.example.litthu_eyelash_app.domain.userInfo.entity

import com.example.litthu_eyelash_app.domain.core.model.BaseResponseDomainEntity
import kotlinx.serialization.Serializable

data class ListStaffLevelDomainEntity(
    override var result: String,
    override var messageID: String,
    override var message: String,
    val staffLevelList: List<StaffLevelDomainEntity>? = null,
) : BaseResponseDomainEntity

@Serializable
data class StaffLevelDomainEntity(
    val id: Int,
    val levelName: String,
    val salaryCoefficient: Double,
    val bonusPerBill: Double,
)