package com.dev.kmmwallet.shared.datasource.webservice.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetUserResponse(
    @SerialName("firstName") var firstName : String,
    @SerialName("lastName") val lastName : String,
    @SerialName("username") val username : String,
    @SerialName("id") val id : String,
    @SerialName("createdDate") val createdDate : String,
)