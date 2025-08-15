package com.example.litthu_eyelash_app.presentation.history.route

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.litthu_eyelash_app.presentation.history.view.HistoryScreenContent

object HistoryScreen : Screen {
    @Composable
    override fun Content() {
        HistoryScreenContent()
    }
}