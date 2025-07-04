package com.example.litthu_eyelash_app.data.model.user

import com.example.litthu_eyelash_app.data.model.BaseResponseEntity
import com.example.litthu_eyelash_app.data.model.BaseResponseExtension
import com.example.litthu_eyelash_app.domain.userInfo.entity.ListStaffLevelDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.entity.StaffLevelDomainEntity
import com.example.litthu_eyelash_app.utils.isNotNegative
import com.example.litthu_eyelash_app.utils.isNotNull
import com.example.litthu_eyelash_app.utils.orDefault
import kotlinx.serialization.Serializable

@Serializable
data class ListStaffLevelResponseEntity(
    val staffLevelList: List<StaffLevelResponseEntity>? = null,
    override var result: String? = null,
    override var messageID: String? = null,
    override var message: String? = null,
) : BaseResponseEntity, BaseResponseExtension<ListStaffLevelDomainEntity> {

    override fun toDomain() = ListStaffLevelDomainEntity(
        result = result.orEmpty(),
        messageID = messageID.orEmpty(),
        message = message.orEmpty(),
        staffLevelList = staffLevelList?.map {
            it.toDomain()
        }
    )
}

@Serializable
data class StaffLevelResponseEntity(
    val id: Int? = null,
    val levelName: String? = null,
    val salaryCoefficient: Double? = null,
    val bonusPerBill: Double? = null,
) : BaseResponseExtension<StaffLevelDomainEntity> {

    override fun toDomain() = StaffLevelDomainEntity(
        id = id.orDefault(),
        levelName = levelName.orEmpty(),
        salaryCoefficient = salaryCoefficient.orDefault(),
        bonusPerBill = bonusPerBill.orDefault(),
    )

    fun checkValidStaffLevelResponse(): Boolean {
        return id.isNotNull() &&
                levelName.isNullOrEmpty().not() &&
                checkIfSalaryCoefficientValid() &&
                checkIfBonusPerBillValid()
    }

    private fun checkIfSalaryCoefficientValid(): Boolean {
        return salaryCoefficient?.isNotNegative() ?: true
    }

    private fun checkIfBonusPerBillValid(): Boolean {
        return bonusPerBill?.isNotNegative() ?: true
    }
}