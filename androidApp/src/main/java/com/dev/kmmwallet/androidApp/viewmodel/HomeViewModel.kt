package com.dev.kmmwallet.androidApp.viewmodel

import com.dev.kmmwallet.shared.viewmodel.event.home.HomeScreenState
import com.dev.kmmwallet.shared.viewmodel.event.home.initHomeScreen
import com.dev.kmmwallet.shared.viewmodel.event.home.logoutUser
import java.util.*

class HomeViewModel : BaseViewModel() {

    fun initHomePage(updateHomeUi: (homeScreenState: HomeScreenState) -> Unit) {
        sharedViewModel.stateProvider.initHomeScreen {
            it.greeting = greetUser()
            updateHomeUi(it)
        }
    }

    private fun greetUser(): String {
        val c: Calendar = Calendar.getInstance()
        val timeOfDay: Int = c.get(Calendar.HOUR_OF_DAY)
        if (timeOfDay in 0..11) {
            return "Good Morning"
        } else if (timeOfDay in 12..15) {
            return "Good Afternoon"
        } else if (timeOfDay in 16..20) {
            return "Good Evening"
        } else if (timeOfDay in 21..23) {
            return "Good Night"
        }
        return ""
    }

    fun logoutUser(onLogout: (logoutState: HomeScreenState) -> Unit) {
        sharedViewModel.stateProvider.logoutUser(){
            onLogout(it)
        }
    }

}