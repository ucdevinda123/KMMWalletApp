package com.dev.kmmwallet.shared.viewmodel.status

import com.dev.kmmwallet.shared.viewmodel.SharedViewModel
import com.dev.kmmwallet.shared.viewmodel.StateProvider

open class ScreenState(
    open val status: Status = Status.LOADING,
    open val message: String = ""
){
    fun getStateProvider(model : SharedViewModel) : StateProvider {
        return model.stateProvider
    }
}