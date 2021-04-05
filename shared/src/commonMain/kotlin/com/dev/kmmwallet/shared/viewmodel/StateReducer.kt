package com.dev.kmmwallet.shared.viewmodel

import com.dev.kmmwallet.shared.datasource.webservice.Repository

class StateReducer(repo: Repository = Repository()) {
    internal val dataRepository by lazy { repo }
}