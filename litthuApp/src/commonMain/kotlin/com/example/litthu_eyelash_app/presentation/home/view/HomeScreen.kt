package com.example.litthu_eyelash_app.presentation.home.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreenContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "This is home screen"
        )
    }
}