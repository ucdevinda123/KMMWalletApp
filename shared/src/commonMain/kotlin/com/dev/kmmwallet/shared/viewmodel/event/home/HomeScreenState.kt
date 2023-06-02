package com.dev.kmmwallet.shared.viewmodel.event.home

import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import com.dev.kmmwallet.shared.viewmodel.status.Status

data class HomeScreenState(override val message: String, override val  status: Status, val name:String = "", val fullName: String = "", var greeting: String = ""): ScreenState()