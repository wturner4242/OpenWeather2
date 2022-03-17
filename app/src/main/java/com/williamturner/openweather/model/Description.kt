package com.williamturner.openweather.model

enum class Description(val value: String) {
    BrokenClouds("broken clouds"),
    ClearSky("clear sky"),
    FewClouds("few clouds"),
    OvercastClouds("overcast clouds"),
    ScatteredClouds("scattered clouds");

    companion object {
        public fun fromValue(value: String): Description = when (value) {
            "broken clouds"    -> BrokenClouds
            "clear sky"        -> ClearSky
            "few clouds"       -> FewClouds
            "overcast clouds"  -> OvercastClouds
            "scattered clouds" -> ScatteredClouds
            else               -> throw IllegalArgumentException()
        }
    }
}