package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.litthu_eyelash_app.presentation.main.view.tab.VoyagerNavTab
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home.widget.OverviewBannerCardWidget
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home.widget.QuickActionsWidget
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home.widget.TodayAppointmentsWidget
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home.widget.TopServicesWidget
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home.widget.TopStaffWidget
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.widget.AppSpace
import com.example.litthu_eyelash_app.presentation.widget.OverscrollLazyColumn
import kotlinx.coroutines.delay

object HomeTab : VoyagerNavTab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 0u,
            title = "Home",
            icon = null,
        )

    override val icon: ImageVector
        get() = Icons.Outlined.Home

    override val selectedIcon: ImageVector
        get() = Icons.Filled.Home

    override val badge: String
        get() = "3"

    @Composable
    override fun Content() {
        HomeTabContent()
    }
}

@Composable
private fun HomeTabContent() {
    var isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(isRefreshing) {
        if (isRefreshing) {
            delay(1200)
            isRefreshing = false
        }
    }

    OverscrollLazyColumn(
        isRefreshing = isRefreshing,
        onRefresh = { isRefreshing = true },
        isPullToRefreshTextVisible = true,
        contentPadding = PaddingValues(AppDimens.DIMEN_24),
    ) {
        item {
            OverviewBannerCardWidget()
        }

        item {
            QuickActionsWidget()
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