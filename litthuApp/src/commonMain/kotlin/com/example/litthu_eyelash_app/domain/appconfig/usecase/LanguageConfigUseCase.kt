package com.example.litthu_eyelash_app.domain.appconfig.usecase

import com.example.litthu_eyelash_app.domain.core.usecase.NonSuspendUseCase
import com.example.litthu_eyelash_app.utils.getLanguageCode

interface LanguageConfigUseCase: NonSuspendUseCase<Unit, String>

class LanguageConfigUseCaseImpl(
    private val getSetAppLanguageUseCase: GetSetAppLanguageUseCase,
): LanguageConfigUseCase {
    override fun execute(parameters: Unit): String {
        return getSetAppLanguageUseCase.get().takeIf { it.isNotEmpty() } ?: getLanguageCode()
    }
}