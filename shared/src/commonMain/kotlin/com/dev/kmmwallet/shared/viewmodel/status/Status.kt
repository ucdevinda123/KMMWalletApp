package com.dev.kmmwallet.shared.viewmodel.status

enum class Status(private val value: String) {
    SUCCESS("Success"),
    ERROR("Error"),
    LOADING("Loading"),
    AUTH_ERROR_GENERIC("We are unable to authenticate you, please check your login details"),
    REG_ERROR_GENERIC("We are unable to create your account, please check your login details"),
    PROFILE_UPDATE_ERROR_GENERIC("We are unable to update your profile, please check the entered details");

    override fun toString() = value
}