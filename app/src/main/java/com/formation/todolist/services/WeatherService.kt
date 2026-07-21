package com.formation.todolist.services

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//
private const val baseUrl = "https://api.openweathermap.org/data/2.5/"

//ajout param retrofit

private  var scarlarsConverterFactor = ScalarsConverterFactory.create()

// contruis retrofit

private val retrofit = Retrofit
    .Builder()
    .addConverterFactory( scarlarsConverterFactor )
    .baseUrl(baseUrl)
    .build()

// interface d appel
interface WeatherService {
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") q: String,
        @Query("units") units: String = "metric",
        @Query("lang") lang:String = "fr",
        @Query("appid") appid: String = APKEY
    ):String
}

//objet d appel

object WeatherApi{
    val weatherService: WeatherService by lazy {
        retrofit.create(WeatherService::class.java)
    }
}