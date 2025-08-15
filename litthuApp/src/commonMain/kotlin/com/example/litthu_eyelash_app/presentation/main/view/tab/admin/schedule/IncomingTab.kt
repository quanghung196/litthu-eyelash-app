package com.example.litthu_eyelash_app.presentation.main.view.tab.admin.schedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.litthu_eyelash_app.presentation.mockdata.MOCK_APPOINTMENT_SECTION
import com.example.litthu_eyelash_app.presentation.schedule.view.FilterControlsWidget
import com.example.litthu_eyelash_app.presentation.schedule.view.ScheduleListWidget

@Composable
private fun IncomingTabContent() {
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