package com.williamturner.openweather.model

import com.google.gson.annotations.SerializedName

data class Weather (
    @SerializedName("id")
    val id: Long,
    @SerializedName("main")
    val main: MainEnum,
    @SerializedName("description")
    val description: Description,
    @SerializedName("icon")
    val icon: String
)