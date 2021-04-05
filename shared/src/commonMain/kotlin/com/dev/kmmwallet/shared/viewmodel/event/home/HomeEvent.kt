package com.dev.kmmwallet.shared.viewmodel.event.home

import com.dev.kmmwallet.shared.viewmodel.Events
import com.dev.kmmwallet.shared.viewmodel.event.LocalSettingsKeys

fun Events.getFirstName() : String {
   return localSettings.getString(LocalSettingsKeys.FIRST_NAME.name)
}

fun Events.getLastName() : String {
    return localSettings.getString(LocalSettingsKeys.LAST_NAME.name)
}

fun Events.clearToken() {
    return localSettings.clear()
}