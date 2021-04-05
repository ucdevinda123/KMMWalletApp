package com.dev.kmmwallet.shared.viewmodel.event

enum class LocalSettingsKeys(private val value: String) {
    TOKEN("token"),
    FIRST_NAME("firstName"),
    LAST_NAME("lastName"),
    ID("id");

    override fun toString() = value
}