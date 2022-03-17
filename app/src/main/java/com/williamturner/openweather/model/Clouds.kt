package com.williamturner.openweather.model

import com.google.gson.annotations.SerializedName

data class Clouds (
    @SerializedName("all")
    val all: Long
)
