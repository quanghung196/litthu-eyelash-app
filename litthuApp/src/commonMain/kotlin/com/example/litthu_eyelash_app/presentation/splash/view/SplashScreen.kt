package com.example.litthu_eyelash_app.presentation.splash.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.example.litthu_eyelash_app.presentation.core.collectAsState
import com.example.litthu_eyelash_app.presentation.splash.viewmodel.SplashViewModel
import com.example.litthu_eyelash_app.presentation.widget.rememberInject
import kotlinx.coroutines.delay
import litthu_eyelash_app.litthuapp.generated.resources.Res
import litthu_eyelash_app.litthuapp.generated.resources.splash_bg
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreenContent(
    onConfigLoaded: (Boolean) -> Unit,
) {

    val viewModel = rememberInject<SplashViewModel>()

    val isLogin by viewModel.collectAsState { it.isLogin }

    LaunchedEffect(isLogin) {
        delay(2000)

        onConfigLoaded.invoke(isLogin)
    }

    Image(
        painter = painterResource(
            resource = Res.drawable.splash_bg,
        ),
        contentDescription = null,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Fit,
    )
}
