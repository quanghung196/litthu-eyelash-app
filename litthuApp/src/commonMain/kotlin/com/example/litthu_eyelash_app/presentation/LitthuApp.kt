package com.example.litthu_eyelash_app.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.litthu_eyelash_app.presentation.core.collectAsState
import com.example.litthu_eyelash_app.presentation.navigation.AppScreen
import com.example.litthu_eyelash_app.presentation.splash.viewmodel.SplashViewModel
import com.example.litthu_eyelash_app.presentation.theme.AppTheme
import com.example.litthu_eyelash_app.presentation.widget.rememberInject

@Composable
fun LitthuApp() {
    AppTheme {
        val viewModel = rememberInject<SplashViewModel>()
        val loginState by viewModel.collectAsState { it.isLogin }
        val configLoaded by viewModel.collectAsState { it.isConfigLoaded }

        if (configLoaded) {
            val startScreen = if (loginState) AppScreen.HomeScreen else AppScreen.LoginScreen

            Navigator(startScreen) { navigator ->
                SlideTransition(navigator)
            }
        }
    }
}

