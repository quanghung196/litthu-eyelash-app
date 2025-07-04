package com.example.litthu_eyelash_app.presentation.main.route

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.example.litthu_eyelash_app.presentation.main.view.MainScreenContent

object MainScreen : Screen {
    @Composable
    override fun Content() {
        MainScreenContent()
    }
}