package com.dev.kmmwallet.androidApp.viewmodel

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.viewmodel.event.userprofile.UserProfileScreenState
import com.dev.kmmwallet.shared.viewmodel.event.userprofile.updateUserProfile
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine
import java.util.*

class HomeViewModel : BaseViewModel() {

    fun updateUserProfile(
        firstName: String,
        lastName: String,
        updateUi: (profileState: UserProfileScreenState) -> Unit
    ) {
        launchCoroutine {
            sharedViewModel.events.updateUserProfile(
                getUserId(),
                getToken(),
                UserProfile(firstName, lastName),
                fun(profileState) {
                    updateUi(profileState)
                })
        }
    }

    fun greetUser():String{
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
}