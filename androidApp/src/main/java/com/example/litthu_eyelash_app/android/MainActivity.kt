package com.example.litthu_eyelash_app.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.litthu_eyelash_app.presentation.LitthuApp
import com.example.litthu_eyelash_app.presentation.splash.viewmodel.SplashViewModel
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val viewModel: SplashViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)

        splashScreen.apply {
            setKeepOnScreenCondition {
                !viewModel.currentState.isConfigLoaded
            }

            setOnExitAnimationListener { splashScreenView ->
                val splashView = splashScreenView.view

                splashView.animate()
                    .alpha(0f)
                    .setDuration(200L)
                    .withEndAction {
                        splashScreenView.remove()
                    }
                    .start()
            }
        }

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            LitthuApp()
        }
    }
}
