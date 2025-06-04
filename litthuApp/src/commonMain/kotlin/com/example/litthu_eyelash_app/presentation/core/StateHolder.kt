package com.example.litthu_eyelash_app.presentation.core

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