package com.maidandhelper.www.forecastmvvmkotlinproject.Data

import com.google.gson.annotations.SerializedName

data class CureentWeatherResponce(


    @SerializedName("current")
    val current: CurrentWeatherEntry,
    val location: Location
)