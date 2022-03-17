package com.williamturner.openweather.remote

import com.williamturner.openweather.model.OpenWeatherResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface OpenWeatherInterface{

    @GET("/data/2.5/forecast")
    fun getCityWithId(@Query("q") cityName:String, @Query("appid") appid :String, @Query("units") units : String) : Call<OpenWeatherResponse>

    companion object {

        var BASE_URL = "https://api.openweathermap.org/data/"

        fun create() : OpenWeatherInterface {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(interceptor) // same for .addInterceptor(...)
                .connectTimeout(30, TimeUnit.SECONDS) //Backend is really slow
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(OpenWeatherInterface::class.java)

        }
    }
}
