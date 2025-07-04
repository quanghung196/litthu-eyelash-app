package com.example.litthu_eyelash_app.presentation.main.view.tab.admin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.outlined.Dashboard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.litthu_eyelash_app.presentation.main.view.tab.VoyagerNavTab

object AdminDashboardTab : VoyagerNavTab {
    override val options: TabOptions
        @Composable
        get() = TabOptions(
            index = 2u,
            title = "Dashboard",
            icon = null,
        )

    override val icon: ImageVector
        get() = Icons.Outlined.Dashboard

    override val selectedIcon: ImageVector
        get() = Icons.Filled.Dashboard

    override val badge: String?
        get() = null

    @Composable
    override fun Content() {
        AdminDashboardContent()
    }
}

@Composable
private fun AdminDashboardContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This is admin Dashboard tab"
        )
    }
}