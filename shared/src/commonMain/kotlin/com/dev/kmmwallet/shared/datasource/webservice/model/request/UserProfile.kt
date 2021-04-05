package com.dev.kmmwallet.shared.datasource.webservice.model.request

import kotlinx.serialization.Serializable


@Serializable
data class UserProfile(val firstName:String, val lastName:String)