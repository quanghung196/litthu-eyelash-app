package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.overview.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace

data class TopService(
    val avatarRes: Int? = null, // resource id của ảnh avatar
    val name: String,
    val totalBooking: Int,
    val totalIncome: String,
)

val topServices = listOf(
    TopService(
        name = "Service 1",
        totalBooking = 30,
        totalIncome = "10M",
    ),
    TopService(
        name = "Service 2",
        totalBooking = 25,
        totalIncome = "9.5M",
    ),
    TopService(
        name = "Service 3",
        totalBooking = 20,
        totalIncome = "8M",
    )
)

@Composable
fun TopServicesWidget() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Top Services",
            color = AppColors.Black.PURE,
            fontWeight = FontWeight.SemiBold,
            fontSize = AppTextSize.TEXT_SIZE_16,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = "See all",
            fontSize = AppTextSize.TEXT_SIZE_12,
            color = AppColors.Gray.LIGHT_SLATE,
        )
    }

    AppSpace.VerticalSpace.Space8()

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = AppColors.White.PURE),
        shape = RoundedCornerShape(AppDimens.DIMEN_8),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_1)
    ) {
        topServices.forEachIndexed { index, service ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppDimens.DIMEN_12),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier.size(AppDimens.DIMEN_40),
                    colors = CardDefaults.cardColors(containerColor = AppColors.Gray.LIGHT_SLATE),
                    shape = CircleShape,
                    elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_0)
                ) {

                }

                AppSpace.HorizontalSpace.Space12()

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = service.name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = AppTextSize.TEXT_SIZE_14,
                        color = AppColors.Black.PURE,
                    )
                    Text(
                        text = "Booked: ${service.totalBooking}",
                        fontSize = AppTextSize.TEXT_SIZE_12,
                        color = AppColors.Gray.LIGHT_SLATE,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = service.totalIncome,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = AppTextSize.TEXT_SIZE_14,
                        color = AppColors.Black.PURE,
                    )
                    Text(
                        text = "this month",
                        fontSize = AppTextSize.TEXT_SIZE_12,
                        color = AppColors.Gray.LIGHT_SLATE,
                    )
                }
            }

            if (index != topStaffs.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.padding(start = AppDimens.DIMEN_36),
                    thickness = AppDimens.DIMEN_0_5,
                    color = Color.LightGray
                )
            }
        }
    }
}