package com.dev.kmmwallet.shared.viewmodel.event.signup

import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status

data class SignUpScreenState(override val message: String, override val  status: Status): ScreenState()