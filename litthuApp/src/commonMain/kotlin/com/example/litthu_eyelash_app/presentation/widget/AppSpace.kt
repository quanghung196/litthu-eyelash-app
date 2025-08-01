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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.litthu_eyelash_app.presentation.theme.AppDimens

object AppSpace {

    object VerticalSpace {
        @Composable
        fun Space2() = Spacer(modifier = Modifier.height(AppDimens.DIMEN_2))

        @Composable
        fun Space4() = Spacer(modifier = Modifier.height(AppDimens.DIMEN_4))

        @Composable
        fun Space8() = Spacer(modifier = Modifier.height(AppDimens.DIMEN_8))

        @Composable
        fun Space12() = Spacer(modifier = Modifier.height(AppDimens.DIMEN_12))

        @Composable
        fun Space16() = Spacer(modifier = Modifier.height(AppDimens.DIMEN_16))

        @Composable
        fun Space20() = Spacer(modifier = Modifier.height(AppDimens.DIMEN_20))

        @Composable
        fun Space24() = Spacer(modifier = Modifier.height(AppDimens.DIMEN_24))

        @Composable
        fun Space60() = Spacer(modifier = Modifier.height(AppDimens.DIMEN_60))
    }

    object HorizontalSpace {

        @Composable
        fun Space12() = Spacer(modifier = Modifier.width(AppDimens.DIMEN_12))

        @Composable
        fun Space16() = Spacer(modifier = Modifier.width(AppDimens.DIMEN_16))

        @Composable
        fun Space24() = Spacer(modifier = Modifier.width(AppDimens.DIMEN_24))
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