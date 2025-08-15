package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.litthu_eyelash_app.presentation.mockdata.MOCK_APPOINTMENT_SECTION
import com.example.litthu_eyelash_app.presentation.schedule.view.FilterControlsWidget
import com.example.litthu_eyelash_app.presentation.schedule.view.ScheduleListWidget

object DoneTab : Tab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 0u,
            title = "Done",
            icon = null,
        )

    @Composable
    override fun Content() {
        DoneTabContent()
    }
}

@Composable
private fun DoneTabContent() {
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
}