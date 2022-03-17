package com.williamturner.openweather.model

enum class Pod(val value: String) {
    D("d"),
    N("n");

    companion object {
        public fun fromValue(value: String): Pod = when (value) {
            "d"  -> D
            "n"  -> N
            else -> throw IllegalArgumentException()
        }
    }
}