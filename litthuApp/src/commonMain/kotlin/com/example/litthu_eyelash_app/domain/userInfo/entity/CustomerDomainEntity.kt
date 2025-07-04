package com.example.litthu_eyelash_app.domain.userInfo.entity

import com.example.litthu_eyelash_app.domain.core.model.BaseResponseDomainEntity
import com.example.litthu_eyelash_app.utils.Constants
import kotlinx.serialization.Serializable

data class ListCustomerDomainEntity(
    override var result: String,
    override var messageID: String,
    override var message: String,
    val customerList: List<CustomerDomainEntity>? = null,
) : BaseResponseDomainEntity

@Serializable
data class CustomerDomainEntity(
    val id: Int = 0,
    val name: String = Constants.EMPTY,
    val phoneNumber: String = Constants.EMPTY,
    val totalBillCount: Int = 0,
    val totalAbsent: Int = 0,
)