package com.maidandhelper.www.forecastmvvmkotlinproject.Data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.maidandhelper.www.forecastmvvmkotlinproject.Data.Network.Responce.CureentWeatherResponce
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val Api_Key = "fba6b02156754ec3ab2223231192805"

//http://api.apixu.com/v1/current.json?key=fba6b02156754ec3ab2223231192805&q=Paris


interface ApixuWeatherApiService
{
    @GET("current.json")
    fun getcurrentWeather
                (
        @Query("q") location :String ,
        @Query("lang") languageCode : String = "en"
    ):Deferred<CureentWeatherResponce>


    companion object
    {
        operator fun invoke():ApixuWeatherApiService
        {

            val requestInterception = Interceptor{ chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key" , Api_Key)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)

            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterception)
                .build()


            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.apixu.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)

        }
    }



}