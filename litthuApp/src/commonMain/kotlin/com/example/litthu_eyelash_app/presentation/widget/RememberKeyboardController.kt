package com.example.litthu_eyelash_app.presentation.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun rememberKeyboardController(): KeyboardController {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val scope = rememberCoroutineScope()

    return remember {
        object : KeyboardController {
            override fun hideKeyboard() {
                scope.launch {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                    delay(100)
                    keyboardController?.hide()
                }
            }

            override fun moveFocus() {
                scope.launch {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            }
        }
    }
}

interface KeyboardController {
    fun hideKeyboard()
    fun moveFocus()
}