package com.dev.kmmwallet.shared.viewmodel

import com.russhwolf.settings.Settings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SharedViewModel {
    val events by lazy { Events(stateReducers,localSettings) }
    private val stateReducers by lazy { StateReducer() }
    val localSettings by lazy { Settings() }
}

fun launchCoroutine(function: suspend () -> Unit) {
    CoroutineScope(Dispatchers.Main).launch {
        function()
    }
}
