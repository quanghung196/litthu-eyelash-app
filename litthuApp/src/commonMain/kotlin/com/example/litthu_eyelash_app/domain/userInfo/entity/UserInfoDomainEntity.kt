package com.example.litthu_eyelash_app.domain.userInfo.entity

import com.example.litthu_eyelash_app.utils.Constants
import kotlinx.serialization.Serializable

@Serializable
data class UserInfoDomainEntity(
    val id: Int = 0,
    val phoneNumber: String = Constants.EMPTY,
    val name: String = Constants.EMPTY,
    val role: UserRole = UserRole.UNKNOWN,
    val staff: StaffDomainEntity? = null,
    val customer: CustomerDomainEntity? = null,
)

@Serializable
enum class UserRole(val value: Int) {
    ADMIN(1),
    STAFF(2),
    CUSTOMER(3),

    UNKNOWN(0);

    companion object {
        fun fromValue(value: Int?): UserRole =
            UserRole.entries.firstOrNull { it.value == value } ?: UNKNOWN

        fun checkValid(value: Int?): Boolean = fromValue(value = value) != UNKNOWN
    }
}