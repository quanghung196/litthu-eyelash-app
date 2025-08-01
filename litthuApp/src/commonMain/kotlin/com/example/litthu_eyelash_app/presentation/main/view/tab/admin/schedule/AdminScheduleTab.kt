package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Event
import androidx.compose.material.icons.outlined.Event
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.litthu_eyelash_app.presentation.main.view.tab.VoyagerNavTab
import com.example.litthu_eyelash_app.presentation.theme.AppDimens

object AdminScheduleTab : VoyagerNavTab {
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
        AdminScheduleContent()
    }
}

@Composable
private fun AdminScheduleContent() {
    val tabs = listOf(
        IncomingTab,
        DoneTab,
        CancelTab,
        PreserveTab,
    )

    TabNavigator(tabs.first()) { tabNavigator ->
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TabRow(
                selectedTabIndex = tabs.indexOf(tabNavigator.current),
                modifier = Modifier.fillMaxWidth()
            ) {
                tabs.forEach { tab ->
                    Tab(
                        selected = tabNavigator.current == tab,
                        onClick = { tabNavigator.current = tab },
                        text = {
                            Text(tab.options.title)
                        },
                    )
                }
            }
            LazyColumn(
                modifier = Modifier
                    .weight(1f),
                // .overscroll(OverscrollBehavior.None),
                // tạo fun expect actual sau actual fun Modifier.noOverscroll(): Modifier = this.overscroll(OverscrollBehavior.None)
                contentPadding = PaddingValues(AppDimens.DIMEN_24)
            ) {
                item {
                    CurrentTab()
                }
            }
        }
    }

}