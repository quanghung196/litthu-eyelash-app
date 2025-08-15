package com.example.litthu_eyelash_app.presentation.schedule.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace.HorizontalSpace.SpaceWeight1


@Composable
fun FilterControlsWidget(
    onTodayClick: () -> Unit,
    onStaffClick: () -> Unit,
    onFilterClick: () -> Unit,
) {
    Card(
        modifier = Modifier.padding(
            horizontal = AppDimens.DIMEN_24,
            vertical = AppDimens.DIMEN_12,
        ),
        shape = RoundedCornerShape(AppDimens.DIMEN_12),
        colors = CardDefaults.cardColors(
            containerColor = AppColors.White.PURE,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_1),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppDimens.DIMEN_12, vertical = AppDimens.DIMEN_8),
            horizontalArrangement = Arrangement.spacedBy(AppDimens.DIMEN_12),
            verticalAlignment = Alignment.CenterVertically
        ) {
            FilterButton(
                icon = Icons.Default.CalendarToday,
                text = "Today",
                onClick = onTodayClick,
            )

            FilterButton(
                icon = Icons.Default.Person,
                text = "All Staff",
                onClick = onStaffClick,
            )

            SpaceWeight1()

            IconButton(
                onClick = onFilterClick,
                modifier = Modifier.size(AppDimens.DIMEN_30)
            ) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "Filter",
                    tint = AppColors.Gray.MID_NIGHT_SLATE,
                    modifier = Modifier.size(AppDimens.DIMEN_20)
                )
            }
        }
    }
}

@Composable
private fun FilterButton(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(AppDimens.DIMEN_8),
        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_1),
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = AppDimens.DIMEN_8, vertical = AppDimens.DIMEN_4),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(AppDimens.DIMEN_2)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AppColors.Gray.MID_NIGHT_SLATE,
                modifier = Modifier
                    .size(AppDimens.DIMEN_14)
                    .clickable(
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() },
                        onClick = onClick
                    )
            )

            Text(
                text = text,
                color = AppColors.Gray.MID_NIGHT_SLATE,
                fontSize = AppTextSize.TEXT_SIZE_10,
                fontWeight = FontWeight.Medium
            )

            Icon(
                imageVector = Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = AppColors.Gray.MID_NIGHT_SLATE,
                modifier = Modifier.size(AppDimens.DIMEN_12)
            )
        }
    }
}