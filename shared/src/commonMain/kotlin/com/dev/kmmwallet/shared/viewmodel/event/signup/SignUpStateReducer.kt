package com.dev.kmmwallet.shared.viewmodel.event.signup

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.datasource.webservice.model.response.UserRegistrationResponse
import com.dev.kmmwallet.shared.viewmodel.StateReducer
import com.dev.kmmwallet.shared.viewmodel.status.Status

suspend fun StateReducer.signUpUser(user: UserRegistration) {

   try {
      val userRegistrationResponse : UserRegistrationResponse = dataRepository.registerUser(user)
      if (userRegistrationResponse.status == 200) {
         stateManager.updateScreen(SignUpScreenState::class){
            it.copy(
               status = Status.SUCCESS,
               message = userRegistrationResponse.message
            )
         }
      } else {
         stateManager.updateScreen(SignUpScreenState::class){
            it.copy(
               status = Status.ERROR,
               message = userRegistrationResponse.message
            )
         }
      }
   } catch (e: Exception) {
     stateManager.updateScreen(SignUpScreenState::class){
         it.copy(
            status = Status.ERROR,
            message =Status.REG_ERROR_GENERIC.toString()
         )
      }
   }
}