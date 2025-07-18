package com.example.litthu_eyelash_app.presentation.main.view.tab.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.filled.BarChart
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Store
import androidx.compose.material.icons.outlined.Assessment
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.litthu_eyelash_app.presentation.main.view.tab.VoyagerNavTab
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.theme.AppTextSize
import com.example.litthu_eyelash_app.presentation.widget.AppSpace
import com.example.litthu_eyelash_app.utils.Constants
import litthu_eyelash_app.litthuapp.generated.resources.Res
import litthu_eyelash_app.litthuapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

object AdminOverviewTab : VoyagerNavTab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 0u,
            title = "Overview",
            icon = null,
        )

    override val icon: ImageVector
        get() = Icons.Outlined.Assessment

    override val selectedIcon: ImageVector
        get() = Icons.Filled.Assessment

    override val badge: String
        get() = "3"

    @Composable
    override fun Content() {
        AdminOverviewContent()
    }
}

@Composable
private fun AdminOverviewContent() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//    ) {
//
//    }
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            shadowElevation = AppDimens.DIMEN_2,
            modifier = Modifier.fillMaxWidth(),
        ) {
            ShopManagerToolbar(
                userName = "Alex",
                notificationCount = 3,
                //avatarPainter = yourAvatarPainter
            )
        }

        AppSpace.VerticalSpace.Space24()

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .padding(horizontal = AppDimens.DIMEN_24)
        ) {
            OverviewBannerCard()
        }
    }
}

@Composable
fun ShopManagerToolbar(
    userName: String = Constants.EMPTY,
    notificationCount: Int = 0,
    //avatarPainter: Painter,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(
                horizontal = AppDimens.DIMEN_16,
                vertical = AppDimens.DIMEN_8,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = AppColors.Gray.LIGHT_SLATE,
            ),
            shape = CircleShape,
            modifier = Modifier.size(AppDimens.DIMEN_36),
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Filled.Store,
                    contentDescription = null,
                    tint = AppColors.White.PURE,
                    modifier = Modifier.size(AppDimens.DIMEN_26)
                )
            }
        }

        AppSpace.HorizontalSpace.Space12()

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(Res.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = AppTextSize.TEXT_SIZE_16,
                lineHeight = AppTextSize.TEXT_SIZE_18,
                color = AppColors.Black.PURE,
            )

            AppSpace.VerticalSpace.Space2()

            Text(
                text = "Hello, $userName",
                fontSize = AppTextSize.TEXT_SIZE_12,
                lineHeight = AppTextSize.TEXT_SIZE_14,
                color = AppColors.Gray.LIGHT_SLATE
            )
        }

        Box(
            modifier = Modifier
                .wrapContentSize()
                .size(AppDimens.DIMEN_30)
        ) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "Notifications",
                tint = AppColors.Gray.LIGHT_SLATE,
                modifier = Modifier.size(AppDimens.DIMEN_26),
            )
            if (notificationCount > 0) {
                Box(
                    modifier = Modifier
                        .size(AppDimens.DIMEN_16)
                        .background(Color.Red, CircleShape)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = notificationCount.toString(),
                        color = Color.White,
                        fontSize = AppTextSize.TEXT_SIZE_8,
                        fontWeight = FontWeight.Bold,
                        lineHeight = AppTextSize.TEXT_SIZE_8,
                    )
                }
            }
        }

        // Avatar
//        Image(
//            painter = avatarPainter,
//            contentDescription = "Avatar",
//            modifier = Modifier
//                .size(36.dp)
//                .clip(CircleShape)
//        )
    }
}

@Composable
fun OverviewBannerCard() {
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