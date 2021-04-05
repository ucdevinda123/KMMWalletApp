package com.dev.kmmwallet.shared.datasource.webservice.model.request

import kotlinx.serialization.Serializable

@Serializable
data class User(val username:String, val password:String)