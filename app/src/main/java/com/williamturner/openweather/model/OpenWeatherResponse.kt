package com.williamturner.openweather.model

import com.google.gson.annotations.SerializedName

data class OpenWeatherResponse(
    @SerializedName("cod")
    val cod: String,
    @SerializedName("message")
    val message: Long,
    @SerializedName("cnt")
    val cnt: Long,
    @SerializedName("list")
    val list: List<ListElement>,
    @SerializedName("city")
    val city: City
)
