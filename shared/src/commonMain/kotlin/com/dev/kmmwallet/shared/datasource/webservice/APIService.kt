package com.dev.kmmwallet.shared.datasource.webservice

import com.dev.kmmwallet.shared.datasource.webservice.model.request.User
import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserRegistration
import com.dev.kmmwallet.shared.datasource.webservice.model.response.AuthResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.BaseResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.GetUserResponse
import com.dev.kmmwallet.shared.datasource.webservice.model.response.UserRegistrationResponse


interface APIService {
    suspend fun authenticateUser(user: User) : AuthResponse
    suspend fun signUpUser(user: UserRegistration) : UserRegistrationResponse
    suspend fun getUserById(id:String,token:String) : GetUserResponse
    suspend fun updateUserProfile(id:String,token:String,userProfile: UserProfile) : BaseResponse
}