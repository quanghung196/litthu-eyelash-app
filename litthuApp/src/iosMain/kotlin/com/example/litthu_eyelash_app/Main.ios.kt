package com.example.litthu_eyelash_app

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController {
        WelcomeScreen()
    }
} 