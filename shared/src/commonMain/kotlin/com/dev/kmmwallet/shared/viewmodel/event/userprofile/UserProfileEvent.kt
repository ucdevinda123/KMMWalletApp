package com.dev.kmmwallet.shared.viewmodel.event.userprofile

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.datasource.webservice.model.response.BaseResponse
import com.dev.kmmwallet.shared.viewmodel.Events
import com.dev.kmmwallet.shared.viewmodel.event.LocalSettingsKeys
import com.dev.kmmwallet.shared.viewmodel.launchCoroutine
import com.dev.kmmwallet.shared.viewmodel.status.Status

fun Events.updateUserProfile(
    id: String,
    token: String,
    user: UserProfile,
    onAuth: (userProfileState: UserProfileScreenState) -> Unit
) {
    launchCoroutine {
        try {
            var userProfileResponse: BaseResponse = stateReducers.updateUserProfile(id, token, user)
            if (userProfileResponse.status == 200) {
                updateFirstName(user.firstName)
                updateLastName(user.lastName)
                onAuth(UserProfileScreenState(Status.SUCCESS, userProfileResponse.message))
            } else {
                onAuth(UserProfileScreenState(Status.ERROR, userProfileResponse.message))
            }
        } catch (e: Exception) {
            onAuth(
                UserProfileScreenState(
                    Status.ERROR,
                    Status.PROFILE_UPDATE_ERROR_GENERIC.toString()
                )
            )
        }
    }
}

fun Events.getId(): String {
    return localSettings.getString(LocalSettingsKeys.ID.name)
}

fun Events.getToken(): String {
    return localSettings.getString(LocalSettingsKeys.TOKEN.name)
}


fun Events.updateFirstName(firstName: String) {
    localSettings.putString(LocalSettingsKeys.FIRST_NAME.name, firstName)
}

fun Events.updateLastName(firstName: String) {
    localSettings.putString(LocalSettingsKeys.LAST_NAME.name, firstName)
}

fun Events.getFirstName(): String {
    return localSettings.getString(LocalSettingsKeys.FIRST_NAME.name)
}

fun Events.getLastName(): String {
    return localSettings.getString(LocalSettingsKeys.LAST_NAME.name)
}