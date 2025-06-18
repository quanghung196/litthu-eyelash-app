package com.example.litthu_eyelash_app.presentation.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

open class BaseViewModel<State : Any>(
    private val initialState: State
) : StateHolder<State> by StateHolderImpl(initialState) {

    val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    fun onDisposed() {
        viewModelScope.cancel()
    }
}