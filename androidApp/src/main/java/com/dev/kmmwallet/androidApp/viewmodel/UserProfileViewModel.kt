package com.dev.kmmwallet.androidApp.viewmodel

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.viewmodel.event.userprofile.UserProfileScreenState
import com.dev.kmmwallet.shared.viewmodel.event.userprofile.getUserProfileState
import com.dev.kmmwallet.shared.viewmodel.event.userprofile.initProfileScreen

class UserProfileViewModel : BaseViewModel() {

    fun updateUserProfile(
        firstName: String,
        lastName: String,
        updateUi: (profileState: UserProfileScreenState) -> Unit
    ) {
        sharedViewModel.stateProvider.getUserProfileState(
            UserProfile(firstName, lastName),
            fun(profileState) {
                updateUi(profileState)
            })
    }

    fun initProfile(updateProfileUi: (profileScreenState: UserProfileScreenState) -> Unit) {
        sharedViewModel.stateProvider.initProfileScreen {
            updateProfileUi(it)
        }
    }
}