package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.litthu_eyelash_app.utils.getLanguageCode

@Composable
fun LanguageObserver(
    onLanguageChanged: (String) -> Unit
) {
    val languageCode = getLanguageCode()

    LaunchedEffect(languageCode) {
        onLanguageChanged(languageCode)
    }
}