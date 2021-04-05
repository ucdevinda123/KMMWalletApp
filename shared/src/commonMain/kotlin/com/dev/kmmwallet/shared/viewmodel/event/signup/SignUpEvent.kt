package com.dev.kmmwallet.shared.viewmodel.event.signup

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.datasource.webservice.model.response.UserRegistrationResponse
import com.dev.kmmwallet.shared.viewmodel.Events
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine
import com.dev.kmmwallet.shared.viewmodel.status.Status


fun Events.userSignUp(user: UserRegistration, onAuth: (token: SignUpScreenState) -> Unit) {
    launchCoroutine {
        try {
            var userRegistrationResponse: UserRegistrationResponse = stateReducers.signUpUser(user)
            if (userRegistrationResponse.status == 200) {
                onAuth(SignUpScreenState(Status.SUCCESS, userRegistrationResponse.message))
            } else {
                onAuth(SignUpScreenState(Status.ERROR, userRegistrationResponse.message))
            }
        } catch (e: Exception) {
            onAuth(SignUpScreenState(Status.ERROR, Status.REG_ERROR_GENERIC.toString()))
        }
    }
}
