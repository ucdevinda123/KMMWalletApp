package com.dev.kmmwallet.androidApp.viewmodel

import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.viewmodel.event.LoginScreenState
import com.dev.kmmwallet.shared.viewmodel.event.userLogin
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine

class LoginViewModel : BaseViewModel(){

    fun authenticateUser(userName : String, pass : String, updateUi : (loginState : LoginScreenState) -> Unit) {
        launchCoroutine {
            sharedViewModel.events.userLogin(User(userName,pass),fun(loginState) {
                updateUi(loginState)
            })
        }
    }
}