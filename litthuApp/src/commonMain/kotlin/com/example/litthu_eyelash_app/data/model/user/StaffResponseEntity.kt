package com.example.litthu_eyelash_app.data.model.user

import com.example.litthu_eyelash_app.data.model.BaseResponseEntity
import com.example.litthu_eyelash_app.data.model.BaseResponseExtension
import com.example.litthu_eyelash_app.domain.userInfo.entity.ListStaffDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.entity.StaffDomainEntity
import com.example.litthu_eyelash_app.utils.isNotNull
import com.example.litthu_eyelash_app.utils.orDefault
import kotlinx.serialization.Serializable


@Serializable
data class ListStaffResponseEntity(
    val staffList: List<StaffResponseEntity>? = null,
    override var result: String? = null,
    override var messageID: String? = null,
    override var message: String? = null,
) : BaseResponseEntity, BaseResponseExtension<ListStaffDomainEntity> {

    override fun toDomain() = ListStaffDomainEntity(
        result = result.orEmpty(),
        messageID = messageID.orEmpty(),
        message = message.orEmpty(),
        staffList = staffList?.map {
            it.toDomain()
        }
    )
}

@Serializable
data class StaffResponseEntity(
    val id: Int? = null,
    val name: String? = null,
    val isActive: Boolean? = null,
    val level: StaffLevelResponseEntity? = null,
    val phoneNumber: String? = null,
) : BaseResponseExtension<StaffDomainEntity> {

    override fun toDomain() = StaffDomainEntity(
        id = id.orDefault(),
        name = name.orEmpty(),
        isActive = isActive.orDefault(),
        level = level?.toDomain(),
        phoneNumber = phoneNumber.orEmpty(),
    )

    fun checkValidStaffResponse(): Boolean {
        return id.isNotNull() &&
                phoneNumber.isNotNull() &&
                checkValidStaffLevelResponse()
    }

    private fun checkValidStaffLevelResponse(): Boolean {
        return level?.checkValidStaffLevelResponse() ?: true
    }
}