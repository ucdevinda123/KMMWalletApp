package com.dev.kmmwallet.shared.datasource.webservice

import com.dev.kmmwallet.shared.datasource.offline.LocalSettingsKeys
import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.datasource.webservice.model.response.AuthResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.BaseResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.GetUserResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.UserRegistrationResponse
import com.russhwolf.settings.Settings

class Repository(private val localSettings : Settings = Settings()) {

    suspend fun authenticateUser(user: User): AuthResponse {
        return APIServiceImpl().authenticateUser(user)
    }

    suspend fun registerUser(user: UserRegistration): UserRegistrationResponse {
        return APIServiceImpl().signUpUser(user)
    }

    suspend fun getUser(id: String, token: String): GetUserResponse {
        return APIServiceImpl().getUserById(id, token)
    }

    suspend fun updateUserProfile(
        userProfile: UserProfile
    ): BaseResponse {
        val userId = getSettingByKey(LocalSettingsKeys.ID.name)
        val token = getSettingByKey(LocalSettingsKeys.TOKEN.name)
        return APIServiceImpl().updateUserProfile(userId, token, userProfile)
    }

    fun saveSetting(key:String,value:String){
        localSettings.putString(key,value)
    }

    fun getSettingByKey(key:String) : String{
        return localSettings.getString(key)
    }

    fun  clearSettings() {
        localSettings.clear()
    }
}
