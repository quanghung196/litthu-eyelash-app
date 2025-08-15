package com.example.litthu_eyelash_app.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = lightColorScheme(
        background = AppColors.White.SMOKE,
        surface = AppColors.White.SMOKE,
    )

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
    )
}
