package com.example.litthu_eyelash_app.presentation.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.litthu_eyelash_app.presentation.home.view.HomeScreenContent
import com.example.litthu_eyelash_app.presentation.login.view.LoginScreenContent

object AppScreen {

    object LoginScreen : Screen {
        @Composable
        override fun Content() {
            val navigator = LocalNavigator.currentOrThrow

            LoginScreenContent(
                onLoginSuccess = {
                    navigator.replaceAll(HomeScreen)
                }
            )
        }
    }

    object HomeScreen : Screen {
        @Composable
        override fun Content() {
            HomeScreenContent()
        }
    }
}