package com.dev.kmmwallet.shared.viewmodel.event.home

import com.dev.kmmwallet.shared.viewmodel.StateProvider
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine
import com.dev.kmmwallet.shared.viewmodel.status.Status
import kotlinx.coroutines.flow.collect

fun StateProvider.initHomeScreen(
    onHome: (HomeScreenState) -> Unit
) {
    launchCoroutine {
        stateManager.getScreen(
            initState = {
                HomeScreenState(
                    status = Status.LOADING,
                    message = Status.LOADING.name
                )
            },
            call = { events.initHome() })

        stateManager.mutableStateFlow.collect { state ->
            run {
                onHome(state as HomeScreenState)
            }
        }
    }
}


fun StateProvider.logoutUser(
    onUserLogout: (HomeScreenState) -> Unit
){
    launchCoroutine {
        stateManager.getScreen(
            initState = {
                HomeScreenState(
                    status = Status.LOADING,
                    message = Status.LOADING.name
                )
            },
            call = { events.logout() })

        stateManager.mutableStateFlow.collect { state ->
            run {
                onUserLogout(state as HomeScreenState)
            }
        }
    }
}