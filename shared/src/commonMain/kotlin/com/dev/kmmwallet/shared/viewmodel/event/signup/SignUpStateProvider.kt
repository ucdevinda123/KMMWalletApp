package com.dev.kmmwallet.shared.viewmodel.event.signup

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.viewmodel.StateProvider
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine
import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status
import kotlinx.coroutines.flow.collect

fun StateProvider.getUserRegistrationState(user: UserRegistration, onSignUpState: (ScreenState) -> Unit){
         launchCoroutine {
             stateManager.getScreen(
                 initState = { SignUpScreenState(status = Status.LOADING,message = Status.LOADING.name) },
                 call = { events.userSignUp(user) })

             stateManager.mutableStateFlow.collect { state ->
                 run {
                     onSignUpState(state)
                 }
             }
         }
}