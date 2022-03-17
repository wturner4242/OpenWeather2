package com.williamturner.openweather.model

import com.google.gson.annotations.SerializedName

data class ListElement(
    @SerializedName("dt")
    val dt: Long,
    @SerializedName("main")
    val main: MainClass,
    @SerializedName("weather")
    val weather: List<Weather>,
    @SerializedName("clouds")
    val clouds: Clouds,
    @SerializedName("wind")
    val wind: Wind,
    @SerializedName("visibility")
    val visibility: Long,
    @SerializedName("pop")
    val pop: Float,
    @SerializedName("sys")
    val sys: Sys,

    @SerializedName("dt_text")
    val dtTxt: String
)
