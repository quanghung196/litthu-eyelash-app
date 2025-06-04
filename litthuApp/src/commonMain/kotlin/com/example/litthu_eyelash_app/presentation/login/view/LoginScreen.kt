package com.example.litthu_eyelash_app.presentation.login.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.litthu_eyelash_app.presentation.login.viewmodel.LoginViewModel
import com.example.litthu_eyelash_app.presentation.widget.rememberInject

@Composable
fun LoginScreen() {
    val viewModel = rememberInject<LoginViewModel>()
    Text(text = viewModel.currentState.helloText.orEmpty())
}