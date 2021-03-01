package com.soha.weather_app.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.soha.weather_app.R
import kotlinx.android.synthetic.main.activity_weather.*
class WeatherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)


        bottomNavigationView.setupWithNavController(navFragment.findNavController())
    }
}

