package com.example.litthu_eyelash_app.presentation.main.view.tab

import androidx.compose.ui.graphics.vector.ImageVector
import cafe.adriel.voyager.navigator.tab.Tab

interface VoyagerNavTab : Tab {
    val icon: ImageVector
    val selectedIcon: ImageVector
    val badge: String?
}

