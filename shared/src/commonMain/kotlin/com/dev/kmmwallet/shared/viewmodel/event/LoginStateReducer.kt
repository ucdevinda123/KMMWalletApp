package com.dev.kmmwallet.shared.viewmodel.event

import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.datasource.webservice.model.response.AuthResponse
import com.dev.kmmwallet.shared.viewmodel.StateReducer

suspend fun StateReducer.authenticateUser(user: User): AuthResponse {
   return dataRepository.authenticateUser(user)
}