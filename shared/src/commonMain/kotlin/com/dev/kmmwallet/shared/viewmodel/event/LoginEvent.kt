package com.dev.kmmwallet.shared.viewmodel.event

import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.viewmodel.Events


suspend fun Events.userLogin(user: User) {
    stateReducers.authenticate(user)
}