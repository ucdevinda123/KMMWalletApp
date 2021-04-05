package com.dev.kmmwallet.shared.viewmodel.event.home

import com.dev.kmmwallet.shared.viewmodel.status.Status

data class HomeScreenState(
    val status: Status = Status.LOADING,
    val message: String = ""
)