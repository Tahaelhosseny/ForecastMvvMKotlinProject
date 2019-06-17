package com.maidandhelper.www.forecastmvvmkotlinproject.Data.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.maidandhelper.www.forecastmvvmkotlinproject.Data.DB.Entity.CURRENT_WEATHER_ID
import com.maidandhelper.www.forecastmvvmkotlinproject.Data.DB.Entity.Current
import com.maidandhelper.www.forecastmvvmkotlinproject.Data.DB.UnitLocalized.ImperialCurrentWeatherEntry
import com.maidandhelper.www.forecastmvvmkotlinproject.Data.DB.UnitLocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: Current)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}