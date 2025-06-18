package com.example.litthu_eyelash_app.presentation.appconfig.viewmodel

import com.example.litthu_eyelash_app.domain.appconfig.usecase.GetSetAppLanguageUseCase
import com.example.litthu_eyelash_app.presentation.appconfig.model.AppLanguage
import com.example.litthu_eyelash_app.presentation.core.BaseViewModel

data class AppConfigState(
    val isDarkMode: Boolean = false,
    val currentLanguage: AppLanguage = AppLanguage.ENGLISH,
    val isLoggedIn: Boolean = false,
    val accessToken: String? = null
)

class AppConfigViewModel(
    private val getSetAppLanguageUseCase: GetSetAppLanguageUseCase,
) : BaseViewModel<AppConfigState>(AppConfigState()) {

    init {
        initAppState()
    }

    private fun initAppState() {
        initAppLanguage()
    }

    private fun initAppLanguage() {
        val appLanguage = getSetAppLanguageUseCase.get()
        dispatchState {
            copy(
                currentLanguage = AppLanguage.fromValue(appLanguage),
            )
        }
    }

} 