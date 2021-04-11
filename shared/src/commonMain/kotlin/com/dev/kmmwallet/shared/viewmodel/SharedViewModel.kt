package com.dev.kmmwallet.shared.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel {
    val stateProvider by lazy { StateProvider(stateManager, events) }
    val events by lazy { Events(stateReducers) }
    private val stateReducers by lazy { StateReducer(stateManager) }
    private val stateManager by lazy { StateManager() }
}

fun launchCoroutine(function: suspend () -> Unit) {
    CoroutineScope(Dispatchers.Main).launch {
        function()
    }
}
