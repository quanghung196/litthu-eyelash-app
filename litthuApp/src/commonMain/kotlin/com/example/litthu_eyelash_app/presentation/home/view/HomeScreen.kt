package com.example.litthu_eyelash_app.presentation.home.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.litthu_eyelash_app.presentation.widget.AppSpace.BoxSafeSpace

@Composable
fun HomeScreenContent() {
    BoxSafeSpace(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = "This is home screen"
        )
    }
}