package com.dev.kmmwallet.shared.datasource.webservice.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    @SerialName("firstName") var firstName : String,
    @SerialName("lastName") val lastName : String,
    @SerialName("username") val username : String,
    @SerialName("id") val id : String,
    @SerialName("token") val token : String,
    @SerialName("message") val message : String,
)