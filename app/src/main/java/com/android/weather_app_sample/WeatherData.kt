package com.android.weather_app_sample

data class WeatherData(val weatherLabel : String, val weatherImg : Int, val currentTemp : Int,
                       val maxTemp : String, val minTemp : String, val precipitation : String,
                       val windSpeed: String, val humidity : String, val weatherBg : Int
                       )