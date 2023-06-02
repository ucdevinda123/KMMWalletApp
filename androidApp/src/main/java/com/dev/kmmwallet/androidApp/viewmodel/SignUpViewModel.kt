package com.dev.kmmwallet.androidApp.viewmodel

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.viewmodel.event.signup.getUserRegistrationState
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine
import com.dev.kmmwallet.shared.viewmodel.status.ScreenState

class SignUpViewModel : BaseViewModel() {
    fun signUpUser(
        userName: String,
        pass: String,
        firstName: String,
        lastName: String,
        updateUi: (loginState: ScreenState) -> Unit
    ) {
        launchCoroutine {
            sharedViewModel.stateProvider.getUserRegistrationState(UserRegistration(userName, pass, firstName, lastName),
                fun(signUpState) {
                    updateUi(signUpState)
                })
        }
    }
}