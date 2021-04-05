package com.dev.kmmwallet.shared.viewmodel.event.userprofile

import com.dev.kmmwallet.shared.viewmodel.status.Status

data class UserProfileScreenState(
    val status: Status = Status.LOADING,
    val message: String = ""
)