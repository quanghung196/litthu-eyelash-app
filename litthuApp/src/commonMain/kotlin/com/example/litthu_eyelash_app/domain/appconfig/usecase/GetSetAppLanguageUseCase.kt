package com.example.litthu_eyelash_app.domain.appconfig.usecase

import com.example.litthu_eyelash_app.domain.appconfig.repository.AppConfigRepository
import com.example.litthu_eyelash_app.domain.core.usecase.GetSetUseCase

interface GetSetAppLanguageUseCase : GetSetUseCase<String>

class GetSetAppLanguageUseCaseImpl(
    private val appConfigRepository: AppConfigRepository,
) : GetSetAppLanguageUseCase {
    override fun set(params: String) {
        appConfigRepository.appLanguage = params
    }

    override fun get(): String {
        return appConfigRepository.appLanguage
    }
}