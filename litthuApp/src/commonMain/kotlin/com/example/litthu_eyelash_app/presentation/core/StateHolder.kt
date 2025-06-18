package com.example.litthu_eyelash_app.presentation.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope

interface StateHolder<T : Any> {

    val currentState: T

    fun dispatchState(newState: T)

    fun dispatchState(newStateExecute: T.() -> T)

    fun <S> observe(
        scope: CoroutineScope,
        selector: (T) -> S,
        observer: (S) -> Unit,
    )
}

@Composable
fun <T : Any, S> StateHolder<T>.collectAsState(
    selector: (T) -> S
): State<S> {
    val initialValue = selector(currentState)
    val state = remember { mutableStateOf(initialValue) }

    LaunchedEffect(this) {
        observe(
            scope = this,
            selector = selector,
            observer = { newValue ->
                state.value = newValue
            }
        )
    }

    return state
}