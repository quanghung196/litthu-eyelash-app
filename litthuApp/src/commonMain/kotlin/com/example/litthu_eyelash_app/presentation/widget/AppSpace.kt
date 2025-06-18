package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

object AppSpace {

    object VerticalSpace {
        @Composable
        fun Space4() = Spacer(modifier = Modifier.height(4.dp))

        @Composable
        fun Space8() = Spacer(modifier = Modifier.height(8.dp))

        @Composable
        fun Space16() = Spacer(modifier = Modifier.height(16.dp))

        @Composable
        fun Space20() = Spacer(modifier = Modifier.height(20.dp))

        @Composable
        fun Space24() = Spacer(modifier = Modifier.height(24.dp))

        @Composable
        fun Space60() = Spacer(modifier = Modifier.height(60.dp))
    }
}