package com.williamturner.openweather.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.williamturner.openweather.Constants
import com.williamturner.openweather.model.ListElement
import com.williamturner.openweather.remote.OpenWeatherInterface
import com.williamturner.openweather.model.OpenWeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SharedViewModel() : ViewModel() {


    fun getOpenWeatherResponse(city : String, callbacks: RevealCallbacks?) {
        var list = arrayListOf<ListElement>()

        val openWeatherInterface = OpenWeatherInterface.create().getCityWithId(city + "",  Constants.OPEN_WEATHER_TOKEN, Constants.OPEN_WEATHER_UNIT_FAHRENHEIT)

        openWeatherInterface.enqueue(object : Callback<OpenWeatherResponse> {
            override fun onResponse(call: Call<OpenWeatherResponse>, response: Response<OpenWeatherResponse>?) {
                if(response?.body() != null){
                    val responseResult = response?.body()!!

                    for(i in 0..6){
                        list.add(responseResult.list[i])
                    }

                    if (callbacks != null)
                        callbacks.onSuccess(list)
                }
            }

            override fun onFailure(call: Call<OpenWeatherResponse>, t: Throwable) {
                Log.d("response failed" , t.stackTraceToString())
                callbacks!!.onFailure(t)
            }
        })


    }

    interface RevealCallbacks {
        fun onSuccess(value: ArrayList<ListElement>)
        fun onFailure(throwable: Throwable)

    }

}