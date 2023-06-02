package com.dev.kmmwallet.shared.viewmodel.event

import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status

data class LoginScreenState(override val message: String, override val  status: Status): ScreenState()