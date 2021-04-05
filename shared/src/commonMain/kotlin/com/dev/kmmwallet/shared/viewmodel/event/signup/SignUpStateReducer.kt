package com.dev.kmmwallet.shared.viewmodel.event.signup

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.datasource.webservice.model.response.UserRegistrationResponse
import com.dev.kmmwallet.shared.viewmodel.StateReducer

suspend fun StateReducer.signUpUser(user: UserRegistration): UserRegistrationResponse {
   return dataRepository.registerUser(user)
}