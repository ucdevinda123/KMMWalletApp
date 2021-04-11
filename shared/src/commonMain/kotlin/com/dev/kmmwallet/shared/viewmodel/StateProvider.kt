package com.dev.kmmwallet.shared.viewmodel

import com.dev.kmmwallet.shared.viewmodel.event.LoginScreenState
import com.dev.kmmwallet.shared.viewmodel.event.signup.SignUpScreenState
import com.dev.kmmwallet.shared.viewmodel.event.userprofile.UserProfileScreenState
import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import kotlin.reflect.KClass

class StateProvider(stateManager: StateManager, events: Events) {
    internal val stateManager by lazy { stateManager }
    internal val events by lazy { events }
}

/* All the Screen types*/
enum class ScreenType { LOGIN, SIGN_UP, HOME, PROFILE }

/*List all screenState classes, defining their screenType*/
fun getScreenType(stateClass: KClass<out ScreenState>): ScreenType {
    return when (stateClass) {
        SignUpScreenState::class -> ScreenType.SIGN_UP
        LoginScreenState::class -> ScreenType.LOGIN
        UserProfileScreenState::class -> ScreenType.PROFILE
        else -> ScreenType.HOME
    }
}