package com.dev.kmmwallet.shared.viewmodel

import com.dev.kmmwallet.shared.viewmodel.status.ScreenState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.reflect.KClass

class StateManager {

    internal val mutableStateFlow = MutableStateFlow(ScreenState())

    val screenStatesMap: MutableMap<ScreenType, ScreenState> = mutableMapOf()

    /*State Reducer is responsible for calling this (Only by itself)*/
    inline fun <reified T : ScreenState> getScreen(initState: () -> T, call: () -> Unit): T? {
        val screenType = getScreenType(T::class)
        screenStatesMap[screenType] as? T
        val initializedState = initState()
        screenStatesMap[screenType] = initializedState
        call()
        return initializedState
    }

    /*State Reducer is responsible for calling this (Only by itself)*/
    inline fun <reified T : ScreenState> updateScreen(stateClass: KClass<T>, update: (T) -> T) {
        val screenType = getScreenType(stateClass)
        var currentState = screenStatesMap[screenType] as? T
        if (currentState != null) { // only perform update if the state class object is currently inside the screenStatesMap
            screenStatesMap[screenType] = update(currentState)
            currentState = update(currentState)
            setState(currentState)

        }
    }

    fun setState(state: ScreenState) {
        mutableStateFlow.value = state
    }
}