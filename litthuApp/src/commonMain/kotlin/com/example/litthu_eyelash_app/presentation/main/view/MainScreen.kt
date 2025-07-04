package com.example.litthu_eyelash_app.presentation.main.view

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserRole
import com.example.litthu_eyelash_app.presentation.core.collectAsState
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.AdminBookingTab
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.AdminDashboardTab
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.AdminOverviewTab
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.AdminSettingTab
import com.example.litthu_eyelash_app.presentation.main.viewmodel.MainViewModel
import com.example.litthu_eyelash_app.presentation.widget.rememberInject


@Composable
fun MainScreenContent() {

    val viewModel = rememberInject<MainViewModel>()
    val userInfo by viewModel.collectAsState { it.userInfo }

    val tabs = when (userInfo?.role) {
        UserRole.ADMIN -> listOf(
            AdminOverviewTab,
            AdminBookingTab,
            AdminDashboardTab,
            AdminSettingTab,
        )

        UserRole.STAFF -> listOf(
            AdminOverviewTab,
            AdminBookingTab,
            AdminDashboardTab,
            AdminSettingTab,
        )

        else -> {
            listOf(
                AdminOverviewTab,
                AdminBookingTab,
                AdminDashboardTab,
                AdminSettingTab,
            )
        }
    }
    TabNavigator(tabs.first()) { tabNavigator ->
        Scaffold {
            CustomBottomNavigationLayout(
                tabNavigator = tabNavigator,
                tabs = tabs,
            )
        }
    }
}

