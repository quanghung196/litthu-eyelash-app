package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

    @Composable
    fun BoxSafeSpace(
        modifier: Modifier = Modifier,
        contentAlignment: Alignment = Alignment.TopStart,
        propagateMinConstraints: Boolean = false,
        content: @Composable BoxScope.() -> Unit,
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing),
            contentAlignment = contentAlignment,
            propagateMinConstraints = propagateMinConstraints,
            content = content,
        )
    }

    @Composable
    fun ColumnSafeSpace(
        modifier: Modifier = Modifier,
        verticalArrangement: Arrangement.Vertical = Arrangement.Top,
        horizontalAlignment: Alignment.Horizontal = Alignment.Start,
        content: @Composable ColumnScope.() -> Unit,
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.safeDrawing),
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement,
            content = content,
        )
    }
}