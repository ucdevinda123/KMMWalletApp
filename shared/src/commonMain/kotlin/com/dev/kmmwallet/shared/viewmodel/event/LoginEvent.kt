package com.dev.kmmwallet.shared.viewmodel.event

import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.datasource.webservice.model.response.AuthResponse
import com.dev.kmmwallet.shared.viewmodel.Events
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine
import com.dev.kmmwallet.shared.viewmodel.status.Status


fun Events.userLogin(user: User, onAuth: (token: LoginScreenState) -> Unit) {
    launchCoroutine {
        try{
            var authResponse: AuthResponse = stateReducers.authenticateUser(user)
            if (authResponse.token != null) {
                saveAccessToken(authResponse.token)
                saveId(authResponse.id)
                saveFirstName(authResponse.firstName)
                saveLastName(authResponse.lastName)
                onAuth(LoginScreenState(authResponse.token, Status.SUCCESS, authResponse.message))
            } else {
                onAuth(LoginScreenState(authResponse.token, Status.ERROR, authResponse.message))
            }
        }catch (e : Exception) {
            onAuth(LoginScreenState("", Status.ERROR, Status.AUTH_ERROR_GENERIC.toString()))
        }

    }
}

fun Events.saveAccessToken(token: String) {
    localSettings.putString(LocalSettingsKeys.TOKEN.name,token)
}

fun Events.saveId(id: String) {
    localSettings.putString(LocalSettingsKeys.ID.name,id)
}

fun Events.saveFirstName(firstName: String) {
    localSettings.putString(LocalSettingsKeys.FIRST_NAME.name,firstName)
}

fun Events.saveLastName(firstName: String) {
    localSettings.putString(LocalSettingsKeys.LAST_NAME.name,firstName)
}
