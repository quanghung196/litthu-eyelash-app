package com.example.litthu_eyelash_app.presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.example.litthu_eyelash_app.presentation.login.view.LoginScreen
import com.example.litthu_eyelash_app.presentation.login.view.LoginScreen.Content
import com.example.litthu_eyelash_app.presentation.theme.LitthuTheme
import com.example.litthu_eyelash_app.presentation.widget.LanguageObserver

@Composable
fun LitthuApp() {
    LitthuTheme {
        LanguageObserver {

        }
        Navigator(LoginScreen) { navigator ->
            Content()
        }
    }
}
