package com.dev.kmmwallet.androidApp.viewmodel

import com.dev.kmmwallet.shared.viewmodel.SharedViewModel
import com.dev.kmmwallet.shared.viewmodel.event.home.clearToken
import com.dev.kmmwallet.shared.viewmodel.event.home.getFirstName
import com.dev.kmmwallet.shared.viewmodel.event.home.getLastName
import com.dev.kmmwallet.shared.viewmodel.event.userprofile.getId
import com.dev.kmmwallet.shared.viewmodel.event.userprofile.getToken

abstract class  BaseViewModel{
    protected var sharedViewModel: SharedViewModel = SharedViewModel()

    fun clearToken() {
        sharedViewModel.events.clearToken()
    }

    fun getFirstName() : String {
        return sharedViewModel.events.getFirstName()
    }

    fun getLastName() : String {
        return sharedViewModel.events.getLastName()
    }


    fun getToken(): String {
        return sharedViewModel.events.getToken()
    }

    fun getUserId(): String {
        return sharedViewModel.events.getId()
    }
}