package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home.widget

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
import androidx.compose.ui.text.font.FontWeight
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace

data class Appointment(
    val avatarRes: Int? = null, // resource id của ảnh avatar
    val name: String,
    val phoneNumber: String,
    val isDeposited: String,
    val time: String,
    val timeLeft: String
)

val appointments = listOf(
    Appointment(
        name = "Sarah Johnson",
        phoneNumber = "0903261998",
        isDeposited = "Deposited",
        time = "10:30 AM",
        timeLeft = "in 45 min"
    ),
    Appointment(
        name = "Michael Torres",
        phoneNumber = "0981002490",
        isDeposited = "No Deposit",
        time = "11:45 AM",
        timeLeft = "in 2 hours"
    ),
    Appointment(
        name = "Dr Strange",
        phoneNumber = "0904561975",
        isDeposited = "No Deposit",
        time = "12:45 AM",
        timeLeft = "in 3 hours"
    )
)

@Composable
fun TodayAppointmentsWidget() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Today's Appointments",
            color = AppColors.Black.PURE,
            fontWeight = FontWeight.SemiBold,
            fontSize = AppTextSize.TEXT_SIZE_14,
            modifier = Modifier.weight(1f),
        )
        Text(
            text = "See all",
            fontSize = AppTextSize.TEXT_SIZE_10,
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
        appointments.forEachIndexed { index, appointment ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(AppDimens.DIMEN_12),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier.size(AppDimens.DIMEN_36),
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
                        text = appointment.name,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = AppTextSize.TEXT_SIZE_14,
                        lineHeight = AppTextSize.TEXT_SIZE_16,
                        color = AppColors.Black.PURE,
                    )

                    AppSpace.VerticalSpace.Space4()

                    Text(
                        text = "${appointment.phoneNumber} • ${appointment.isDeposited}",
                        fontSize = AppTextSize.TEXT_SIZE_10,
                        lineHeight = AppTextSize.TEXT_SIZE_12,
                        color = AppColors.Gray.LIGHT_SLATE,
                    )
                }
                Column(
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = appointment.time,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = AppTextSize.TEXT_SIZE_14,
                        lineHeight = AppTextSize.TEXT_SIZE_16,
                        color = AppColors.Black.PURE,
                    )

                    AppSpace.VerticalSpace.Space4()

                    Text(
                        text = appointment.timeLeft,
                        fontSize = AppTextSize.TEXT_SIZE_10,
                        lineHeight = AppTextSize.TEXT_SIZE_12,
                        color = AppColors.Gray.LIGHT_SLATE,
                    )
                }
            }

            if (index != appointments.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.padding(start = AppDimens.DIMEN_36),
                    thickness = AppDimens.DIMEN_0_5,
                    color = AppColors.Gray.LIGHT,
                )
            }
        }
    }
}