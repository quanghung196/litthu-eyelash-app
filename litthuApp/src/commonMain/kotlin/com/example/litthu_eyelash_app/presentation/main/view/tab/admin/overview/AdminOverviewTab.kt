package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.outlined.Assessment
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.litthu_eyelash_app.presentation.main.view.tab.VoyagerNavTab
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.overview.widget.OverviewBannerCardWidget
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.overview.widget.QuickActionsWidget
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.overview.widget.TodayAppointmentsWidget
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.overview.widget.ToolbarWidget
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.overview.widget.TopServicesWidget
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.overview.widget.TopStaffWidget
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.widget.AppSpace

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
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ToolbarWidget(
            userName = "Alex",
            notificationCount = 3,
            //avatarPainter = yourAvatarPainter
        )

        HorizontalDivider(
            thickness = AppDimens.DIMEN_0_5,
            color = Color.LightGray
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f),
            // .overscroll(OverscrollBehavior.None),
            // tạo fun expect actual sau actual fun Modifier.noOverscroll(): Modifier = this.overscroll(OverscrollBehavior.None)
            contentPadding = PaddingValues(AppDimens.DIMEN_24)
        ) {
            item {
                OverviewBannerCardWidget()
            }

            item {
                AppSpace.VerticalSpace.Space24()
            }

            item {
                QuickActionsWidget()
            }

            item {
                AppSpace.VerticalSpace.Space12()
            }

            item {
                TodayAppointmentsWidget()
            }

            item {
                AppSpace.VerticalSpace.Space12()
            }

            item {
                TopStaffWidget()
            }

            item {
                AppSpace.VerticalSpace.Space12()
            }

            item {
                TopServicesWidget()
            }
        }
    }
}