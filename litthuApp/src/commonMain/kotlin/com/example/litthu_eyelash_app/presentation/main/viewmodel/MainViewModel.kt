package com.example.litthu_eyelash_app.presentation.main.viewmodel

import com.example.litthu_eyelash_app.domain.userInfo.entity.StaffDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserInfoDomainEntity
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserRole
import com.example.litthu_eyelash_app.domain.userInfo.usecase.GetSetUserInfoUseCase
import com.example.litthu_eyelash_app.presentation.core.BaseViewModel

data class MainViewState(
    val userInfo: UserInfoDomainEntity? = null,
)

class MainViewModel(
    private val getSetUserInfoUseCase: GetSetUserInfoUseCase,
) : BaseViewModel<MainViewState>(MainViewState()) {

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        getSetUserInfoUseCase.get()?.let {
            dispatchState {
                copy(userInfo = it)
            }
        } ?: run {
            dispatchState {
                copy(userInfo = mockUserInfo)
            }
        }
    }
}

val mockUserInfo = UserInfoDomainEntity(
    id = 0,
    phoneNumber = "0981002490",
    name = "Nguyễn Anh Thư",
    role = UserRole.ADMIN,
    staff = StaffDomainEntity(
        id = 0,
        name = "Nguyễn Anh Thư",
        phoneNumber = "0981002490",
        isActive = true,
    )
)