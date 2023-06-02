package com.dev.kmmwallet.shared.viewmodel.event.userprofile

import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status

data class UserProfileScreenState(override val message: String, override val  status: Status, val name  : String = "", val lastName: String = ""): ScreenState()