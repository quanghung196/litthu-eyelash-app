package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home.widget

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.litthu_eyelash_app.presentation.history.route.HistoryScreen
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace

data class QuickAction(
    val type: QuickActionType,
    val icon: ImageVector,
    val iconColor: Color,
)

val quickActions = listOf(
    QuickAction(
        type = QuickActionType.HISTORY,
        icon = Icons.Filled.History,
        iconColor = Color(0xFF4285F4)
    ),
    QuickAction(
        type = QuickActionType.INVENTORY,
        icon = Icons.Filled.Inventory,
        iconColor = Color(0xFF34A853)
    ),
    QuickAction(
        type = QuickActionType.REPORTS,
        icon = Icons.Filled.Description,
        iconColor = Color(0xFF9B51E0)
    ),
    QuickAction(
        type = QuickActionType.BOOKING,
        icon = Icons.Filled.Event,
        iconColor = Color(0xFFFF8C1A)
    )
)

enum class QuickActionType(val action: String) {
    HISTORY("History"),
    INVENTORY("Inventory"),
    REPORTS("Reports"),
    BOOKING("Booking"),
}

@Composable
fun QuickActionsWidget() {

    val navigator = LocalNavigator.currentOrThrow

    fun onClickItem(action: QuickAction) {
        when (action.type) {
            QuickActionType.HISTORY -> {
                navigator.push(HistoryScreen)
            }

            QuickActionType.INVENTORY -> {

            }

            QuickActionType.REPORTS -> {

            }

            QuickActionType.BOOKING -> {

            }
        }
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = AppDimens.DIMEN_20,
                vertical = AppDimens.DIMEN_24,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        quickActions.forEachIndexed { index, action ->
            Column(
                modifier = Modifier.weight(1f).clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() },
                ) {
                    onClickItem(action = action)
                },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = action.icon,
                    contentDescription = null,
                    tint = action.iconColor,
                    modifier = Modifier.size(AppDimens.DIMEN_30)
                )

                AppSpace.VerticalSpace.Space4()

                Text(
                    text = action.type.action,
                    color = AppColors.Black.PURE,
                    fontSize = AppTextSize.TEXT_SIZE_10,
                    fontWeight = FontWeight.Normal,
                    lineHeight = AppTextSize.TEXT_SIZE_12,
                )
            }

            if (index < quickActions.size - 1) {
                VerticalDottedDivider(
                    modifier = Modifier
                        .width(AppDimens.DIMEN_1)
                        .height(AppDimens.DIMEN_30)
                        .padding(horizontal = AppDimens.DIMEN_4)
                )
            }
        }
    }
}

@Composable
fun VerticalDottedDivider(
    modifier: Modifier = Modifier,
    color: Color = AppColors.Gray.LIGHT,
    strokeWidth: Dp = AppDimens.DIMEN_1,
    dashLength: Dp = AppDimens.DIMEN_3,
    gapLength: Dp = AppDimens.DIMEN_3
) {
    Canvas(modifier = modifier) {
        val pathEffect = PathEffect.dashPathEffect(
            floatArrayOf(dashLength.toPx(), gapLength.toPx()),
            0f
        )

        drawLine(
            color = color,
            start = Offset(size.width / 2, 0f),
            end = Offset(size.width / 2, size.height),
            strokeWidth = strokeWidth.toPx(),
            pathEffect = pathEffect
        )
    }
}