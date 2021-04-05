package com.dev.kmmwallet.shared.viewmodel

import com.russhwolf.settings.Settings

class Events (stateReducers: StateReducer, settings: Settings) {
    internal val stateReducers by lazy { stateReducers }
    internal val localSettings by lazy { settings }
}