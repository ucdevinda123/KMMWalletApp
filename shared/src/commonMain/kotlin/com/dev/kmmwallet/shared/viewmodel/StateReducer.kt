package com.dev.kmmwallet.shared.viewmodel

import com.dev.kmmwallet.shared.datasource.webservice.Repository

class StateReducer(stateManager : StateManager,repo: Repository = Repository()) {
    internal val dataRepository by lazy { repo }
    internal val stateManager by lazy { stateManager }
}