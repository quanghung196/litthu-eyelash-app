package com.example.litthu_eyelash_app.presentation.schedule.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.outlined.Event
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.litthu_eyelash_app.presentation.main.view.tab.VoyagerNavTab
import com.example.litthu_eyelash_app.presentation.mockdata.MOCK_APPOINTMENT_SECTION

object ScheduleTab : VoyagerNavTab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 1u,
            title = "Schedule",
            icon = null,
        )

    override val icon: ImageVector
        get() = Icons.Outlined.Event

    override val selectedIcon: ImageVector
        get() = Icons.Filled.Event

    override val badge: String?
        get() = null

    @Composable
    override fun Content() {
        ScheduleContent()
    }
}

@Composable
private fun ScheduleContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        FilterControlsWidget(
            onTodayClick = { /* Handle today selection */ },
            onStaffClick = { /* Handle staff selection */ },
            onFilterClick = { /* Handle filter action */ }
        )

        ScheduleListWidget(
            onCallClick = {},
            appointments = MOCK_APPOINTMENT_SECTION,
        )
    }
//    val tabs = listOf(
//        IncomingTab,
//        DoneTab,
//    )
//
//    TabNavigator(tabs.first()) { tabNavigator ->
//        Column(
//            modifier = Modifier.fillMaxSize()
//        ) {
//            val selectedTabIndex = tabs.indexOf(tabNavigator.current)
//
//            TabRow(
//                selectedTabIndex = selectedTabIndex,
//                modifier = Modifier.fillMaxWidth(),
//                indicator = { tabPositions ->
//                    if (selectedTabIndex < tabPositions.size) {
//                        SecondaryIndicator(
//                            modifier = Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
//                            color = AppColors.Gray.MID_NIGHT_SLATE,
//                            height = AppDimens.DIMEN_2,
//                        )
//                    }
//                }
//            ) {
//                tabs.forEachIndexed { index, tab ->
//                    Tab(
//                        selected = tabNavigator.current == tab,
//                        onClick = { tabNavigator.current = tab },
//                        text = {
//                            Text(
//                                text = tab.options.title,
//                                fontSize = AppTextSize.TEXT_SIZE_12,
//                                fontWeight = if (selectedTabIndex == index)
//                                    FontWeight.SemiBold else FontWeight.Normal
//                            )
//                        },
//                        selectedContentColor = AppColors.Gray.MID_NIGHT_SLATE,
//                        unselectedContentColor = AppColors.Gray.LIGHT_SLATE,
//                    )
//                }
//            }
//            // --- Animated content area ---
//            val currentTab = tabNavigator.current
//            var lastIndex by remember { mutableStateOf(selectedTabIndex) }
//            val goingForward = selectedTabIndex >= lastIndex
//
//            LaunchedEffect(selectedTabIndex) { lastIndex = selectedTabIndex }
//
//            val transitionSpec: AnimatedContentTransitionScope<Tab>.() -> ContentTransform = {
//                val dur = 260
//                val slideIn = slideInHorizontally(
//                    animationSpec = tween(dur, easing = FastOutSlowInEasing),
//                    initialOffsetX = { w -> if (goingForward) +w / 3 else -w / 3 }
//                ) + fadeIn(tween(dur))
//
//                val slideOut = slideOutHorizontally(
//                    animationSpec = tween(dur, easing = FastOutSlowInEasing),
//                    targetOffsetX = { w -> if (goingForward) -w / 3 else +w / 3 }
//                ) + fadeOut(tween(dur))
//
//                slideIn togetherWith slideOut
//            }
//
//            AnimatedContent(
//                targetState = currentTab,
//                transitionSpec = transitionSpec,
//                modifier = Modifier
//                    .weight(1f)
//                    .fillMaxWidth()
//            ) { tab ->
//                tab.Content()
//            }
//        }
//    }
}