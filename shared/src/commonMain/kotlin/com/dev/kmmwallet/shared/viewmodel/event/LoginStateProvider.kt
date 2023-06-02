package com.dev.kmmwallet.shared.viewmodel.event

import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.viewmodel.StateProvider
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine
import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status
import kotlinx.coroutines.flow.collect

fun StateProvider.getUserAuthState(user: User, onAuthState: (ScreenState) -> Unit){
         launchCoroutine {
             stateManager.getScreen(
                 initState = { LoginScreenState(status = Status.LOADING,message = Status.LOADING.name) },
                 call = { events.userLogin(user) })

             stateManager.mutableStateFlow.collect { state ->
                 run {
                     onAuthState(state)
                 }
             }
         }
}