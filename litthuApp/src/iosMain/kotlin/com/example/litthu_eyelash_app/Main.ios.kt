package com.example.litthu_eyelash_app

import androidx.compose.ui.window.ComposeUIViewController
import com.example.litthu_eyelash_app.di.initKoin
import com.example.litthu_eyelash_app.presentation.LitthuApp
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController(configure = {
        initKoin()
    }) {
        LitthuApp()
    }
} 