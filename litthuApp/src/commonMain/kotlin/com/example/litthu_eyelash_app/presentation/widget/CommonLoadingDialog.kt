package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize

@Composable
fun CommonLoadingDialog(
    title: String? = null,
    message: String? = null,
) {
    Dialog(
        onDismissRequest = { },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Card(
            modifier = Modifier
                .padding(AppDimens.DIMEN_24),
            colors = CardDefaults.cardColors(
                containerColor = AppColors.White.TRANSPARENT_95,
            ),
            shape = RoundedCornerShape(AppDimens.DIMEN_24),
            elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_16)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(AppDimens.DIMEN_16),
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(AppDimens.DIMEN_40),
                    color = AppColors.Gray.DARK,
                    strokeWidth = AppDimens.DIMEN_3,
                )

                title?.let {
                    AppSpace.VerticalSpace.Space16()

                    Text(
                        text = it,
                        fontSize = AppTextSize.TEXT_SIZE_14,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.Black.PURE,
                    )
                }

                message?.let {
                    AppSpace.VerticalSpace.Space8()

                    Text(
                        text = it,
                        lineHeight = AppTextSize.TEXT_SIZE_18,
                        fontSize = AppTextSize.TEXT_SIZE_12,
                        color = AppColors.Gray.LIGHT_SLATE,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}
