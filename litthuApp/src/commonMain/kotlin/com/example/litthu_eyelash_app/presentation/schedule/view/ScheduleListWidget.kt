package com.example.litthu_eyelash_app.presentation.schedule.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.litthu_eyelash_app.presentation.mockdata.Appointment
import com.example.litthu_eyelash_app.presentation.mockdata.AppointmentSection
import com.example.litthu_eyelash_app.presentation.mockdata.AppointmentStatus
import com.example.litthu_eyelash_app.presentation.mockdata.AppointmentType
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace
import com.example.litthu_eyelash_app.presentation.widget.OverscrollLazyColumn
import kotlinx.coroutines.delay
import litthu_eyelash_app.litthuapp.generated.resources.Res
import litthu_eyelash_app.litthuapp.generated.resources.no_appointments_left
import org.jetbrains.compose.resources.stringResource

@Composable
fun ScheduleListWidget(
    onCallClick: () -> Unit,
    appointments: List<AppointmentSection>,
) {
    var isRefreshing by remember { mutableStateOf(false) }
    var isLoadingMore by remember { mutableStateOf(false) }
    var hasMore by remember { mutableStateOf(true) }

    // Refresh
    LaunchedEffect(isRefreshing) {
        if (isRefreshing) {
            delay(2000)
            hasMore = true
            isRefreshing = false
        }
    }

    // Load-more
    LaunchedEffect(isLoadingMore) {
        if (isLoadingMore) {
            // Call API
            delay(2000)
            hasMore = false
            isLoadingMore = false
        }
    }

    OverscrollLazyColumn(
        isRefreshing = isRefreshing,
        onRefresh = { isRefreshing = true },
        modifier = Modifier.fillMaxSize(),
        isLoadingMore = isLoadingMore,
        onLoadMore = { if (!isRefreshing && !isLoadingMore && hasMore) isLoadingMore = true },
        hasMore = hasMore,
        noMoreContentText = stringResource(Res.string.no_appointments_left),
    ) {
        appointments.forEach { section ->
            stickyHeader {
                DateHeader(date = section.date)
            }

            itemsIndexed(section.appointments) { index, appointment ->
                IncomingAppointmentCard(
                    appointment = appointment,
                    onCallClick = onCallClick,
                )

                if (index != section.appointments.lastIndex) {
                    AppSpace.VerticalSpace.Space8()
                }
            }
        }
    }
}

@Composable
private fun DateHeader(date: String) {
    Box(
        modifier = Modifier.fillMaxWidth().background(color = AppColors.White.SMOKE)
    ) {
        Text(
            text = date,
            fontSize = AppTextSize.TEXT_SIZE_12,
            fontWeight = FontWeight.SemiBold,
            color = AppColors.Gray.LIGHT_SLATE,
            modifier = Modifier.padding(
                horizontal = AppDimens.DIMEN_12,
                vertical = AppDimens.DIMEN_4,
            )
        )
    }
}

@Composable
private fun IncomingAppointmentCard(
    appointment: Appointment,
    onCallClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = AppDimens.DIMEN_24),
        shape = RoundedCornerShape(AppDimens.DIMEN_12),
        colors = CardDefaults.cardColors(containerColor = AppColors.White.PURE),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_0)
    ) {
        Column(
            modifier = Modifier.padding(
                vertical = AppDimens.DIMEN_8,
                horizontal = AppDimens.DIMEN_12,
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(AppDimens.DIMEN_4),
                verticalAlignment = Alignment.Top
            ) {
                Text(
                    text = appointment.name,
                    fontSize = AppTextSize.TEXT_SIZE_14,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )

                TypeBadge(type = appointment.type)

                StatusBadge(status = appointment.status)
            }

            AppSpace.VerticalSpace.Space4()

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Schedule,
                    contentDescription = null,
                    tint = AppColors.Gray.LIGHT_SLATE,
                    modifier = Modifier.size(AppDimens.DIMEN_14)
                )

                AppSpace.HorizontalSpace.Space8()

                Text(
                    text = appointment.time,
                    fontSize = AppTextSize.TEXT_SIZE_10,
                    lineHeight = AppTextSize.TEXT_SIZE_12,
                    color = AppColors.Gray.LIGHT_SLATE,
                )
            }

            AppSpace.VerticalSpace.Space4()

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = AppColors.Gray.LIGHT_SLATE,
                    modifier = Modifier.size(AppDimens.DIMEN_14)
                )

                AppSpace.HorizontalSpace.Space8()

                Text(
                    text = appointment.doctor,
                    fontSize = AppTextSize.TEXT_SIZE_10,
                    lineHeight = AppTextSize.TEXT_SIZE_12,
                    color = AppColors.Gray.LIGHT_SLATE,
                )
            }

            HorizontalDivider(
                modifier = Modifier.padding(vertical = AppDimens.DIMEN_4),
                thickness = AppDimens.DIMEN_0_5,
            )

            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(end = AppDimens.DIMEN_12),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = appointment.bookedTime,
                    fontSize = AppTextSize.TEXT_SIZE_10,
                    color = AppColors.Gray.LIGHT_SLATE,
                )

                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Call",
                    tint = AppColors.Gray.DEEP_SLATE,
                    modifier = Modifier
                        .size(AppDimens.DIMEN_20)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() },
                            onClick = onCallClick
                        )
                )
            }
        }
    }
}

@Composable
private fun StatusBadge(status: AppointmentStatus) {
    val (backgroundColor, textColor) = when (status) {
        AppointmentStatus.DEPOSITED -> AppColors.AppointmentBadge.STATUS_DEPOSITED_BG to AppColors.AppointmentBadge.STATUS_DEPOSITED_TEXT
        AppointmentStatus.NO_DEPOSIT -> AppColors.AppointmentBadge.STATUS_NO_DEPOSIT_BG to AppColors.AppointmentBadge.STATUS_NO_DEPOSIT_TEXT
    }

    Text(
        text = status.status,
        fontSize = AppTextSize.TEXT_SIZE_8,
        fontWeight = FontWeight.Medium,
        color = textColor,
        modifier = Modifier.background(
            color = backgroundColor,
            shape = RoundedCornerShape(AppDimens.DIMEN_16)
        ).padding(
            horizontal = AppDimens.DIMEN_12,
        )
    )
}

@Composable
private fun TypeBadge(type: AppointmentType) {
    val (backgroundColor, textColor) = when (type) {
        AppointmentType.NEW -> AppColors.AppointmentBadge.TYPE_NEW_BG to AppColors.AppointmentBadge.TYPE_NEW_TEXT
        AppointmentType.TOUCH_UP -> AppColors.AppointmentBadge.TYPE_TOUCH_UP_BG to AppColors.AppointmentBadge.TYPE_TOUCH_UP_TEXT
    }

    Text(
        text = type.type,
        fontSize = AppTextSize.TEXT_SIZE_8,
        fontWeight = FontWeight.Medium,
        color = textColor,
        modifier = Modifier.background(
            color = backgroundColor,
            shape = RoundedCornerShape(AppDimens.DIMEN_16)
        ).padding(
            horizontal = AppDimens.DIMEN_12,
        )
    )
}

