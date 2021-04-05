package com.dev.kmmwallet.shared.viewmodel.event.signup

import com.dev.kmmwallet.shared.viewmodel.status.Status

data class SignUpScreenState(
    val status: Status = Status.LOADING,
    val message: String = ""
)