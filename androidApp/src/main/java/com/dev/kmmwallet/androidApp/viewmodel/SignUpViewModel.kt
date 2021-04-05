package com.dev.kmmwallet.androidApp.viewmodel

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.viewmodel.event.signup.SignUpScreenState
import com.dev.kmmwallet.shared.viewmodel.event.signup.userSignUp
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine

class SignUpViewModel : BaseViewModel() {
    fun signUpUser(
        userName: String,
        pass: String,
        firstName: String,
        lastName: String,
        updateUi: (loginState: SignUpScreenState) -> Unit
    ) {
        launchCoroutine {
            sharedViewModel.events.userSignUp(UserRegistration(userName, pass, firstName, lastName),
                fun(signUpState) {
                    updateUi(signUpState)
                })
        }
    }
}