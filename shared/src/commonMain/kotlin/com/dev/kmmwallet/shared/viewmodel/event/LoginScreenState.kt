package com.dev.kmmwallet.shared.viewmodel.event

import com.dev.kmmwallet.shared.viewmodel.status.Status

data class LoginScreenState(
    val token: String = "",
    val status: Status = Status.LOADING,
    val message: String = ""
)