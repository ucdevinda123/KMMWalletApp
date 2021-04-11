package com.dev.kmmwallet.shared.viewmodel.event.userprofile

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.viewmodel.Events

suspend fun Events.updateUserProfile(
    user: UserProfile,
) {
   stateReducers.updateUserProfile(user)
}

suspend fun Events.initProfile() {
    stateReducers.initProfile()
}