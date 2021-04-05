package com.dev.kmmwallet.shared.datasource.webservice

import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.datasource.webservice.model.response.AuthResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.BaseResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.GetUserResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.UserRegistrationResponse

class Repository {

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
        id: String,
        token: String,
        userProfile: UserProfile
    ): BaseResponse {
        return APIServiceImpl().updateUserProfile(id, token, userProfile)
    }


}
