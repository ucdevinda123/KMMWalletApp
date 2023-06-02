package com.dev.kmmwallet.shared.viewmodel.event

import com.dev.kmmwallet.shared.datasource.offline.LocalSettingsKeys
import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.viewmodel.StateReducer
import com.dev.kmmwallet.shared.viewmodel.status.Status


suspend fun StateReducer.authenticate(user: User) {
      try {
         val authResponse =  dataRepository.authenticateUser(user)
         val accessToken = authResponse.token
         val id = authResponse.id
         val firstName = authResponse.firstName
         val lastName = authResponse.lastName
         dataRepository.saveSetting(LocalSettingsKeys.TOKEN.name,accessToken)
         dataRepository.saveSetting(LocalSettingsKeys.ID.name,id)
         dataRepository.saveSetting(LocalSettingsKeys.FIRST_NAME.name,firstName)
         dataRepository.saveSetting(LocalSettingsKeys.LAST_NAME.name,lastName)

         stateManager.updateScreen(LoginScreenState::class){
            it.copy(
               status = Status.SUCCESS,
               message = authResponse.message
            )
         }
      }catch (e : Exception) {
         stateManager.updateScreen(LoginScreenState::class){
           it.copy(
               status = Status.ERROR,
               message =  Status.AUTH_ERROR_GENERIC.toString()
            )
         }
      }
}