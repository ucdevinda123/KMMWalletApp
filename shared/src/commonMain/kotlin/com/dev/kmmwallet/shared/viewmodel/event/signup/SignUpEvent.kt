package com.dev.kmmwallet.shared.viewmodel.event.signup

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.viewmodel.Events

suspend fun Events.userSignUp(user: UserRegistration) {
   stateReducers.signUpUser(user)
}