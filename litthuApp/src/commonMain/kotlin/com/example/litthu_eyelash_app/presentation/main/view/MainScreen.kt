package com.example.litthu_eyelash_app.presentation.main.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.example.litthu_eyelash_app.domain.userInfo.entity.UserRole
import com.example.litthu_eyelash_app.presentation.core.collectAsState
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.AdminAnalyticsTab
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.AdminSettingTab
import com.example.litthu_eyelash_app.presentation.main.view.tab.admin.home.HomeTab
import com.example.litthu_eyelash_app.presentation.main.view.tab.bottomnavigation.CustomBottomBarItem
import com.example.litthu_eyelash_app.presentation.main.viewmodel.MainViewModel
import com.example.litthu_eyelash_app.presentation.schedule.view.ScheduleTab
import com.example.litthu_eyelash_app.presentation.theme.AppColors
import com.example.litthu_eyelash_app.presentation.theme.AppDimens
import com.example.litthu_eyelash_app.presentation.widget.AppSpace
import com.example.litthu_eyelash_app.presentation.widget.rememberInject


@Composable
fun MainScreenContent() {

    val viewModel = rememberInject<MainViewModel>()
    val userInfo by viewModel.collectAsState { it.userInfo }

    val tabs = when (userInfo?.role) {
        UserRole.ADMIN -> listOf(
            HomeTab,
            ScheduleTab,
            AdminAnalyticsTab,
            AdminSettingTab,
        )

        UserRole.STAFF -> listOf(
            HomeTab,
            ScheduleTab,
            AdminAnalyticsTab,
            AdminSettingTab,
        )

        else -> {
            listOf(
                HomeTab,
                ScheduleTab,
                AdminAnalyticsTab,
                AdminSettingTab,
            )
        }
    }
    TabNavigator(tabs.first()) {
        Scaffold(
            bottomBar = {
                AppSpace.BoxSafeSpaceForSystemBar {
                    BottomAppBar(
                        containerColor = AppColors.White.PURE,
                        modifier = Modifier
                            .height(AppDimens.DIMEN_60)
                            .align(Alignment.TopCenter),
                    ) {
                        tabs.forEach { tab ->
                            CustomBottomBarItem(tab = tab)
                        }
                    }
                }
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                CurrentTab()
            }
        }
    }
}

