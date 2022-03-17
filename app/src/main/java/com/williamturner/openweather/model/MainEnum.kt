package com.williamturner.openweather.model

enum class MainEnum(val value: String) {
    Clear("Clear"),
    Clouds("Clouds");

    companion object {
        public fun fromValue(value: String): MainEnum = when (value) {
            "Clear"  -> Clear
            "Clouds" -> Clouds
            else     -> throw IllegalArgumentException()
        }
    }
}