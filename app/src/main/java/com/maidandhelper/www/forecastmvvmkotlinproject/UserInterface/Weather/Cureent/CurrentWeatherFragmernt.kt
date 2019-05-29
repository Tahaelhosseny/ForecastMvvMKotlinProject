package com.maidandhelper.www.forecastmvvmkotlinproject.UserInterface.Weather.Cureent

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.maidandhelper.www.forecastmvvmkotlinproject.Data.ApixuWeatherApiService

import com.maidandhelper.www.forecastmvvmkotlinproject.R
import kotlinx.android.synthetic.main.current_weather_fragmernt_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragmernt : Fragment() {

    companion object {
        fun newInstance() =
            CurrentWeatherFragmernt()
    }

    private lateinit var viewModel: CurrentWeatherFragmerntViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragmernt_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherFragmerntViewModel::class.java)
        // TODO: Use the ViewModel


        val apiService = ApixuWeatherApiService()
        GlobalScope.launch ( Dispatchers.Main ){this
            val currentWeatherResponce = apiService.getcurrentWeather("London" , "en").await()
            textView.text = currentWeatherResponce.current.toString()

        }


    }

}
