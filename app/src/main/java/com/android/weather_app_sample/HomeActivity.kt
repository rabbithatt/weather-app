package com.android.weather_app_sample

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val minTempToday = minTemp()
    private val maxTempToday = maxTemp(minTempToday)

    private val minTempTomorrow = minTemp()
    private val maxTempTomorrow = maxTemp(minTempTomorrow)

    //Data to populate the weather fields
    private val minTempTxtToday = "${minTempToday}°"
    private val maxTempTxtToday = "${maxTempToday}°"
    private val currentTempTxtToday = currentTemp(minTempToday, maxTempToday)
    private val windSpeedToday = "${(0..60).shuffled().first()}km/h"
    private val precipitationToday = "${(0..100).shuffled().first()}mm"
    private val humidityToday = "${(0..100).shuffled().first()}%"

    private val minTempTxtTomorrow = "${minTempTomorrow}°"
    private val maxTempTxtTomorrow = "${maxTempTomorrow}°"
    private val currentTempTxtTomorrow = currentTemp(minTempTomorrow, maxTempTomorrow)
    private val windSpeedTomorrow = "${(0..60).shuffled().first()}km/h"
    private val precipitationTomorrow = "${(0..100).shuffled().first()}mm"
    private val humidityTomorrow = "${(0..100).shuffled().first()}%"

    private val weatherImages = arrayOf(R.drawable.ic_image_sunny, R.drawable.ic_image_partlycloudy,
        R.drawable.ic_image_mostlycloudy , R.drawable.ic_image_cloudy,  R.drawable.ic_image_showers,
        R.drawable.ic_image_rain, R.drawable.ic_image_thunderstorm
        )

    private val weatherLabel = arrayOf("Sunny", "Party Cloudy", "Mostly Cloudy", "Cloudy", "Showers",
                                        "Rain", "Thunderstorm"
                                        )

    private val weatherBg = arrayOf(R.drawable.bg_gradient_sun, R.drawable.bg_gradient_sun,
                                        R.drawable.bg_gradient_sun, R.drawable.bg_gradient_cloud,
                                        R.drawable.bg_gradient_cloud, R.drawable.bg_gradient_cloud,
                                        R.drawable.bg_gradient_thunderstorm
                                        )

    //Random number to pick the weather from today and tomorrow
    private val weatherDisplayRndNumToday = (0..6).shuffled().first()
    private val weatherDisplayRndNumTomorrow = (0..6).shuffled().first()

    private val weatherDataBank = arrayOf(
        WeatherData(weatherLabel[weatherDisplayRndNumToday], weatherImages[weatherDisplayRndNumToday],
                    currentTempTxtToday,maxTempTxtToday,minTempTxtToday,precipitationToday,windSpeedToday, humidityToday,weatherBg[weatherDisplayRndNumToday]
                    ),
        WeatherData(weatherLabel[weatherDisplayRndNumTomorrow], weatherImages[weatherDisplayRndNumTomorrow],
                    currentTempTxtTomorrow,maxTempTxtTomorrow,minTempTxtTomorrow,precipitationTomorrow,windSpeedTomorrow, humidityTomorrow,weatherBg[weatherDisplayRndNumTomorrow]
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        generateData(0)

        today_btn.setOnClickListener{
            generateData(0)
        }

        tomorrow_btn.setOnClickListener{
            generateData(1)
        }
    }

    //Populate the grid function
    private fun generateData(index : Int){
        val bgMainActivity = findViewById<View>(R.id.activity_home)
        val weatherDisplay = findViewById<ImageView>(R.id.weatherImg)
        val weatherText = findViewById<TextView>(R.id.weather_label)
        val humidity = findViewById<TextView>(R.id.humidity_id)
        val currentTemp = findViewById<TextView>(R.id.current_temp_id)
        val minTemp = findViewById<TextView>(R.id.min_temp_id)
        val maxTemp = findViewById<TextView>(R.id.max_temp_id)
        val precipitation = findViewById<TextView>(R.id.precipitation_id)
        val windSpeed = findViewById<TextView>(R.id.wind_speed_id)

        bgMainActivity.setBackgroundResource(weatherDataBank[index].weatherBg)
        weatherDisplay.setImageResource(weatherDataBank[index].weatherImg)
        weatherText.text = weatherDataBank[index].weatherLabel
        humidity.text = weatherDataBank[index].humidity
        minTemp.text = weatherDataBank[index].minTemp
        currentTemp.text = weatherDataBank[index].currentTemp.toString()
        maxTemp.text = weatherDataBank[index].maxTemp
        precipitation.text = weatherDataBank[index].precipitation
        windSpeed.text = weatherDataBank[index].windSpeed
    }

    private fun minTemp() : Int {
        return (0..39).shuffled().first()
    }

    private fun maxTemp(minTemp: Int) : Int {
        return (minTemp..40).shuffled().first()
    }

    private fun currentTemp  (minTemp : Int, maxTemp : Int) : Int {
        return (minTemp..maxTemp).shuffled().first()
    }
}











