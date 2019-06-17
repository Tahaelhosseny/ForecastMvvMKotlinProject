package com.maidandhelper.www.forecastmvvmkotlinproject.Data.Network.Responce

import com.google.gson.annotations.SerializedName
import com.maidandhelper.www.forecastmvvmkotlinproject.Data.DB.Entity.Current
import com.maidandhelper.www.forecastmvvmkotlinproject.Data.DB.Entity.Location

data class CureentWeatherResponce(

	@field:SerializedName("current")
	val current: Current? = null,

	@field:SerializedName("location")
	val location: Location? = null
)