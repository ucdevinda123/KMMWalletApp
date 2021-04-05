package com.dev.kmmwallet.shared.viewmodel.event.userprofile

import com.dev.kmmwallet.shared.datasource.webservice.model.request.UserProfile
import com.dev.kmmwallet.shared.datasource.webservice.model.response.BaseResponse
import com.dev.kmmwallet.shared.viewmodel.StateReducer

suspend fun StateReducer.updateUserProfile(id:String,token:String,user: UserProfile): BaseResponse {
   return dataRepository.updateUserProfile(id,token,user)
}