package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.mp.KoinPlatform.getKoin

@Composable
inline fun <reified T : Any> rememberInject(): T {
    return remember { getKoin().get<T>() }
}