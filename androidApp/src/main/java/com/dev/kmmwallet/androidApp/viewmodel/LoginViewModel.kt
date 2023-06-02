package com.dev.kmmwallet.androidApp.viewmodel

import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.viewmodel.event.getUserAuthState
import com.dev.kmmwallet.shared.viewmodel.status.ScreenState

class LoginViewModel : BaseViewModel() {

    fun authenticateUser(
        userName: String,
        pass: String,
        updateUi: (loginState: ScreenState) -> Unit
    ) {
        sharedViewModel.stateProvider.getUserAuthState(
            User(userName, pass),
            fun(loginState: ScreenState) {
                updateUi(loginState)
            })
    }
}