package com.example.litthu_eyelash_app.data.model.user

import com.example.litthu_eyelash_app.data.model.BaseResponseEntity
import com.example.litthu_eyelash_app.data.model.BaseResponseExtension
import com.example.litthu_eyelash_app.domain.userInfo.entity.CustomerDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.entity.ListCustomerDomainEntity
import com.example.litthu_eyelash_app.utils.isNotNull
import com.example.litthu_eyelash_app.utils.orDefault
import kotlinx.serialization.Serializable

@Serializable
data class ListCustomerResponseEntity(
    val customerList: List<CustomerResponseEntity>? = null,
    override var result: String? = null,
    override var messageID: String? = null,
    override var message: String? = null,
) : BaseResponseEntity, BaseResponseExtension<ListCustomerDomainEntity> {

    override fun toDomain() = ListCustomerDomainEntity(
        result = result.orEmpty(),
        messageID = messageID.orEmpty(),
        message = message.orEmpty(),
        customerList = customerList?.map {
            it.toDomain()
        }
    )
}

@Serializable
data class CustomerResponseEntity(
    val id: Int? = null,
    val name: String? = null,
    val phoneNumber: String? = null,
    val totalBillCount: Int? = null,
    val totalAbsent: Int? = null,
) : BaseResponseExtension<CustomerDomainEntity> {

    override fun toDomain() = CustomerDomainEntity(
        id = id.orDefault(),
        name = name.orEmpty(),
        phoneNumber = phoneNumber.orEmpty(),
        totalBillCount = totalBillCount.orDefault(),
        totalAbsent = totalAbsent.orDefault()
    )

    fun checkValidCustomerResponse(): Boolean {
        return id.isNotNull()
    }
}