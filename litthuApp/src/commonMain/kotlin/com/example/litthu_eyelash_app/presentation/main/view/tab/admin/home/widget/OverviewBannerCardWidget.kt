package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace

@Composable
fun OverviewBannerCardWidget() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = AppColors.Gray.LIGHT_SLATE,
        ),
        shape = RoundedCornerShape(AppDimens.DIMEN_12),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_4)
    ) {
        Column(
            modifier = Modifier.padding(
                horizontal = AppDimens.DIMEN_16,
                vertical = AppDimens.DIMEN_20,
            )
        ) {
            Row {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Today's Overview",
                        fontWeight = FontWeight.Bold,
                        fontSize = AppTextSize.TEXT_SIZE_20,
                        color = AppColors.White.PURE,
                    )

                    Text(
                        text = "June 23, 2025",
                        fontSize = AppTextSize.TEXT_SIZE_13,
                        color = AppColors.White.TRANSPARENT_80,
                    )
                }

                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = AppColors.Gray.LIGHT,
                    ),
                    shape = RoundedCornerShape(AppDimens.DIMEN_8),
                    elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_4),
                    modifier = Modifier.size(AppDimens.DIMEN_36),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Filled.BarChart,
                            contentDescription = null,
                            tint = AppColors.White.PURE,
                            modifier = Modifier.size(AppDimens.DIMEN_26)
                        )
                    }
                }
            }

            AppSpace.VerticalSpace.Space8()

            Row {
                Column {
                    Text(
                        text = "Sales",
                        fontSize = AppTextSize.TEXT_SIZE_12,
                        color = AppColors.White.TRANSPARENT_80,
                        lineHeight = AppTextSize.TEXT_SIZE_14,
                    )

                    Text(
                        text = "$1,245",
                        fontWeight = FontWeight.Bold,
                        fontSize = AppTextSize.TEXT_SIZE_18,
                        color = AppColors.White.PURE,
                    )
                }

                AppSpace.HorizontalSpace.Space16()

                Column {
                    Text(
                        lineHeight = AppTextSize.TEXT_SIZE_14,
                        text = "Appointments",
                        fontSize = AppTextSize.TEXT_SIZE_12,
                        color = AppColors.White.TRANSPARENT_80,
                    )

                    Text(
                        text = "8",
                        fontWeight = FontWeight.Bold,
                        fontSize = AppTextSize.TEXT_SIZE_18,
                        color = AppColors.White.PURE,
                    )
                }
            }
        }
    }
}