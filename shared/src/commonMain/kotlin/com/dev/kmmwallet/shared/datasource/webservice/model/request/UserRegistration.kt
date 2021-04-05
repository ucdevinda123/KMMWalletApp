package com.dev.kmmwallet.shared.datasource.webservice.model.request

import kotlinx.serialization.Serializable

@Serializable
data class UserRegistration(val username:String, val password:String, val firstName:String, val lastName:String)