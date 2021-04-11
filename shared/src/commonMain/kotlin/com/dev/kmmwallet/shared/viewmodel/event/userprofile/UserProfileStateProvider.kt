package com.dev.kmmwallet.shared.viewmodel.event.userprofile

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.viewmodel.StateProvider
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine
import com.dev.kmmwallet.shared.viewmodel.status.Status
import kotlinx.coroutines.flow.collect

fun StateProvider.getUserProfileState(
    user: UserProfile,
    onUpdateProfileState: (UserProfileScreenState) -> Unit
) {
    launchCoroutine {
        stateManager.getScreen(
            initState = {
                UserProfileScreenState(
                    status = Status.LOADING,
                    message = Status.LOADING.name,
                    name = user.firstName,
                    lastName = user.lastName
                )
            },
            call = { events.updateUserProfile(user) })

        stateManager.mutableStateFlow.collect { state ->
            run {
                onUpdateProfileState(state as UserProfileScreenState)
            }
        }
    }
}

fun StateProvider.initProfileScreen(
    onProfileScreen: (UserProfileScreenState) -> Unit
) {
    launchCoroutine {
        stateManager.getScreen(
            initState = {
                UserProfileScreenState(
                    status = Status.LOADING,
                    message = Status.LOADING.name
                )
            },
            call = { events.initProfile() })

        stateManager.mutableStateFlow.collect { state ->
            run {
                onProfileScreen(state as UserProfileScreenState)
            }
        }
    }
}