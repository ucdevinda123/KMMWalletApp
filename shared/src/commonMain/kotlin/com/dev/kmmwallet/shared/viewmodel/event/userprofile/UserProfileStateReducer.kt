package com.dev.kmmwallet.shared.viewmodel.event.userprofile

import com.dev.kmmwallet.shared.datasource.offline.LocalSettingsKeys
import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.datasource.webservice.model.response.BaseResponse
import com.dev.kmmwallet.shared.viewmodel.StateReducer
import com.dev.kmmwallet.shared.viewmodel.event.home.HomeScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status

suspend fun StateReducer.updateUserProfile(user: UserProfile) {
    try {
        var userProfileResponse: BaseResponse = dataRepository.updateUserProfile(user)
        if (userProfileResponse.status == 200) {
            dataRepository.saveSetting(LocalSettingsKeys.FIRST_NAME.name, user.firstName)
            dataRepository.saveSetting(LocalSettingsKeys.LAST_NAME.name, user.lastName)

            stateManager.updateScreen(UserProfileScreenState::class) {
                it.copy(
                    status = Status.SUCCESS,
                    message = userProfileResponse.message,
                    name = user.firstName
                )
            }

        } else {
            stateManager.updateScreen(UserProfileScreenState::class) {
                it.copy(
                    status = Status.ERROR,
                    message = userProfileResponse.message,
                )
            }
        }
    } catch (e: Exception) {
        stateManager.updateScreen(UserProfileScreenState::class) {
            it.copy(
                status = Status.ERROR,
                message = Status.PROFILE_UPDATE_ERROR_GENERIC.toString(),
            )
        }
    }
}


suspend fun StateReducer.initProfile() {
    try {
        val firstName = dataRepository.getSettingByKey(LocalSettingsKeys.FIRST_NAME.name)
        val lastName =  dataRepository.getSettingByKey(LocalSettingsKeys.LAST_NAME.name)
        stateManager.updateScreen(UserProfileScreenState::class) {
            it.copy(
                status = Status.SUCCESS,
                name = firstName,
                lastName = lastName
            )
        }
    } catch (e: Exception) {
        stateManager.updateScreen(UserProfileScreenState::class) {
            it.copy(
                status = Status.ERROR,
            )
        }
    }
}