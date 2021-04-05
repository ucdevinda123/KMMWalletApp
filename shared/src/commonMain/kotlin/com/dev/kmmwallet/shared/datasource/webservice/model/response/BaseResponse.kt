package com.dev.kmmwallet.shared.datasource.webservice.model.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse(val message : String , val status : Int)