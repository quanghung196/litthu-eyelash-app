package com.example.litthu_eyelash_app.data.model.user

import com.example.litthu_eyelash_app.data.model.BaseResponseExtension
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserInfoDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserRole
import com.example.litthu_eyelash_app.utils.Constants.ParamLength.LENGTH_10
import com.example.litthu_eyelash_app.utils.isNotNull
import com.example.litthu_eyelash_app.utils.orDefault
import kotlinx.serialization.Serializable

@Serializable
data class UserInfoResponseEntity(
    val id: Int? = null,
    val phoneNumber: String? = null,
    val name: String? = null,
    val role: Int? = null,
    val staff: StaffResponseEntity? = null,
    val customer: CustomerResponseEntity? = null,
) : BaseResponseExtension<UserInfoDomainEntity> {

    override fun toDomain() = UserInfoDomainEntity(
        id = id.orDefault(),
        phoneNumber = phoneNumber.orEmpty(),
        name = name.orEmpty(),
        role = UserRole.fromValue(role),
        staff = staff?.toDomain(),
        customer = customer?.toDomain()
    )

    fun checkValidUserInfo(): Boolean {
        return id.isNotNull() &&
                phoneNumber?.length == LENGTH_10 &&
                UserRole.checkValid(role) &&
                (staff.isNotNull() || customer.isNotNull()) &&
                checkValidStaffResponse() &&
                checkValidCustomerResponse()
    }

    private fun checkValidStaffResponse(): Boolean {
        return staff?.checkValidStaffResponse() ?: true
    }

    private fun checkValidCustomerResponse(): Boolean {
        return customer?.checkValidCustomerResponse() ?: true
    }
}

