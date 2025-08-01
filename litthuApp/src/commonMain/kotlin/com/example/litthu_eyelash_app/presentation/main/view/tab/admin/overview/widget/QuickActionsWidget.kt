package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.overview.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace

data class QuickAction(
    val title: String,
    val icon: ImageVector,
    val iconColor: Color,
    val bgColor: Color
)

val quickActions = listOf(
    QuickAction("History", Icons.Filled.History, Color(0xFF4285F4), Color(0xFFE3F0FF)),
    QuickAction("Inventory", Icons.Filled.Inventory, Color(0xFF34A853), Color(0xFFE6F4EA)),
    QuickAction("Reports", Icons.Filled.Description, Color(0xFF9B51E0), Color(0xFFF3E8FD)),
    QuickAction("Booking", Icons.Filled.Event, Color(0xFFFF8C1A), Color(0xFFFFF3E0))
)

@Composable
fun QuickActionsWidget() {
    Text(
        text = "Quick Actions",
        color = AppColors.Black.PURE,
        fontWeight = FontWeight.SemiBold,
        fontSize = AppTextSize.TEXT_SIZE_16,
    )

    AppSpace.VerticalSpace.Space8()

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(AppDimens.DIMEN_8)
    ) {
        quickActions.forEach { action ->
            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(containerColor = AppColors.White.PURE),
                shape = RoundedCornerShape(AppDimens.DIMEN_8),
                elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_1)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(AppDimens.DIMEN_100),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Card(
                        modifier = Modifier.size(AppDimens.DIMEN_40),
                        colors = CardDefaults.cardColors(containerColor = action.bgColor),
                        shape = CircleShape,
                        elevation = CardDefaults.cardElevation(defaultElevation = AppDimens.DIMEN_0)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = action.icon,
                                contentDescription = null,
                                tint = action.iconColor,
                                modifier = Modifier.size(AppDimens.DIMEN_24)
                            )
                        }
                    }

                    AppSpace.VerticalSpace.Space8()

                    Text(
                        text = action.title,
                        color = AppColors.Black.PURE,
                        fontSize = AppTextSize.TEXT_SIZE_12,
                        fontWeight = FontWeight.Normal,
                        lineHeight = AppTextSize.TEXT_SIZE_14,
                    )
                }
            }
        }
    }
}