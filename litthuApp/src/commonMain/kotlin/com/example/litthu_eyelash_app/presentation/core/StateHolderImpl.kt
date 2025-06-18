package com.example.litthu_eyelash_app.presentation.core

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class StateHolderImpl<T : Any>(initializeState: T) : StateHolder<T> {

    private val stateFlow: MutableStateFlow<T> by lazy {
        MutableStateFlow(initializeState)
    }

    override val currentState: T
        get() = stateFlow.value

    override fun <S> observe(scope: CoroutineScope, selector: (T) -> S, observer: (S) -> Unit) {
        scope.launch {
            stateFlow.map(selector)
                .distinctUntilChanged()
                .collect { selectedValue ->
                    observer(selectedValue)
                }
        }
    }

    override fun dispatchState(newStateExecute: T.() -> T) {
        stateFlow.tryEmit(currentState.newStateExecute())
    }

    override fun dispatchState(newState: T) {
        stateFlow.tryEmit(newState)
    }
}