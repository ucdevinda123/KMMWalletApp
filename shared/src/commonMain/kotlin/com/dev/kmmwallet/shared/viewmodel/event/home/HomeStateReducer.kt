package com.dev.kmmwallet.shared.viewmodel.event.home

import com.dev.kmmwallet.shared.datasource.offline.LocalSettingsKeys
import com.dev.kmmwallet.shared.viewmodel.StateReducer
import com.dev.kmmwallet.shared.viewmodel.status.Status

suspend fun StateReducer.initHome() {
    try {
        val firstName = dataRepository.getSettingByKey(LocalSettingsKeys.FIRST_NAME.name)
        val lastName =  dataRepository.getSettingByKey(LocalSettingsKeys.LAST_NAME.name)
      stateManager.updateScreen(HomeScreenState::class) {
                it.copy(
                    status = Status.SUCCESS,
                    name = firstName,
                    fullName =  "$firstName $lastName"
                )
            }
    } catch (e: Exception) {
        stateManager.updateScreen(HomeScreenState::class) {
            it.copy(
                status = Status.ERROR,
            )
        }
    }
}

suspend fun StateReducer.logoutUser() {
    try {
        dataRepository.clearSettings()
        stateManager.updateScreen(HomeScreenState::class) {
            it.copy(
                status = Status.SUCCESS,
            )
        }
    } catch (e: Exception) {
        stateManager.updateScreen(HomeScreenState::class) {
            it.copy(
                status = Status.ERROR,
            )
        }
    }
}