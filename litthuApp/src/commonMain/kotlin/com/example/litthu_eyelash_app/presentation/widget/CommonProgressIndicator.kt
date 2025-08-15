package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens

@Composable
fun CommonProgressIndicator(
    modifier: Modifier = Modifier,
    progress: (() -> Float)? = null,
) {
    val indicatorColor = AppColors.Gray.LIGHT_SLATE
    val indicatorTrackColor = AppColors.Gray.LIGHT_SLATE.copy(alpha = 0.2f)
    val indicatorSize = AppDimens.DIMEN_20

    progress?.let {
        CircularProgressIndicator(
            color = indicatorColor,
            trackColor = indicatorTrackColor,
            modifier = modifier.size(indicatorSize),
            progress = progress,
        )
    } ?: run {
        CircularProgressIndicator(
            color = indicatorColor,
            trackColor = indicatorTrackColor,
            modifier = modifier.size(indicatorSize),
        )
    }
}