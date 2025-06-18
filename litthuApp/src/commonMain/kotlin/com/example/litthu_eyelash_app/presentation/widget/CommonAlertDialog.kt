package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import litthu_eyelash_app.litthuapp.generated.resources.Res
import litthu_eyelash_app.litthuapp.generated.resources.close
import litthu_eyelash_app.litthuapp.generated.resources.retry
import org.jetbrains.compose.resources.stringResource

@Composable
fun CommonAlertDialog(
    messageTitle: String,
    messageDetail: String,
    onDismiss: () -> Unit,
    onRetry: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
            usePlatformDefaultWidth = false
        )
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppDimens.DIMEN_24),
            colors = CardDefaults.cardColors(
                containerColor = AppColors.White.TRANSPARENT_95,
            ),
            shape = RoundedCornerShape(AppDimens.DIMEN_24),
            elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_16),
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AppDimens.DIMEN_24)
                        .padding(
                            top = AppDimens.DIMEN_24,
                            bottom = AppDimens.DIMEN_12,
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(AppDimens.DIMEN_12),
                ) {
                    Box(
                        modifier = Modifier
                            .size(AppDimens.DIMEN_40)
                            .background(
                                AppColors.White.MISTY_ROSE,
                                CircleShape,
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Error,
                            contentDescription = null,
                            tint = AppColors.Red.TOMATO,
                            modifier = Modifier.size(AppDimens.DIMEN_20)
                        )
                    }
                    Text(
                        text = messageTitle,
                        fontSize = AppTextSize.TEXT_SIZE_18,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.Gray.MID_NIGHT_SLATE
                    )
                }

                HorizontalDivider(
                    thickness = AppDimens.DIMEN_2,
                    color = AppColors.White.LAVENDER_50,
                )

                Text(
                    text = messageDetail,
                    fontSize = AppTextSize.TEXT_SIZE_14,
                    color = AppColors.Gray.LIGHT_SLATE,
                    lineHeight = AppTextSize.TEXT_SIZE_20,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = AppDimens.DIMEN_24,
                            vertical = AppDimens.DIMEN_12
                        )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AppDimens.DIMEN_24)
                        .padding(
                            top = AppDimens.DIMEN_12,
                            bottom = AppDimens.DIMEN_24,
                        ),
                    horizontalArrangement = Arrangement.spacedBy(AppDimens.DIMEN_12)
                ) {
                    Button(
                        onClick = {
                            onDismiss.invoke()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(AppDimens.DIMEN_48),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppColors.White.SMOKE,
                            contentColor = AppColors.Gray.DEEP_SLATE
                        ),
                        shape = RoundedCornerShape(AppDimens.DIMEN_12)
                    ) {
                        Text(
                            text = stringResource(Res.string.close),
                            fontWeight = FontWeight.Medium
                        )
                    }

                    Button(
                        onClick = {
                            onDismiss.invoke()
                            onRetry.invoke()
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(AppDimens.DIMEN_48),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AppColors.Gray.DEEP_SLATE,
                            contentColor = AppColors.White.PURE
                        ),
                        shape = RoundedCornerShape(AppDimens.DIMEN_12),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = AppDimens.DIMEN_4
                        )
                    ) {
                        Text(
                            text = stringResource(Res.string.retry),
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

    }
}