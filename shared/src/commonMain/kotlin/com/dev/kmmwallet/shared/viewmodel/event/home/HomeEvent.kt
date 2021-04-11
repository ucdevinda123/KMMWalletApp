package com.dev.kmmwallet.shared.viewmodel.event.home

import com.dev.kmmwallet.shared.viewmodel.Events

suspend fun Events.initHome() {
    stateReducers.initHome()
}

suspend fun Events.logout() {
    stateReducers.logoutUser()
}