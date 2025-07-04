package com.example.litthu_eyelash_app.presentation.auth.route

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.litthu_eyelash_app.presentation.auth.view.LoginScreenContent
import com.example.litthu_eyelash_app.presentation.main.route.MainScreen

object LoginScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        LoginScreenContent(
            onLoginSuccess = {
                navigator.replaceAll(MainScreen)
            }
        )
    }
}