package com.example.litthu_eyelash_app.presentation.main.view.tab.admin

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Assessment
import androidx.compose.material.icons.outlined.Assessment
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.example.litthu_eyelash_app.presentation.main.view.tab.VoyagerNavTab

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
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "This is admin Overview tab"
        )
    }
}