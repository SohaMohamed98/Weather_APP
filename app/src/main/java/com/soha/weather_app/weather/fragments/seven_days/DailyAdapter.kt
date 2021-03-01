package com.soha.weather_app.weather.fragments.seven_days

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.soha.weather_app.databinding.ForecastWeatherHourlyItemBinding
import com.soha.weather_app.utils.dayConverter
import com.soha.weather_app.utils.model.Daily
import com.soha.weather_app.utils.setImage

class DailyAdapter(var daysList: List<Daily>) :
RecyclerView.Adapter<DailyAdapter.DailyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyViewHolder {

        val view = ForecastWeatherHourlyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false)

        return DailyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return daysList.size
    }



    override fun onBindViewHolder(holder: DailyViewHolder, position: Int) {

        holder.bind(daysList[position])

    }

    fun updateHourlyList(newHourlyList: List<Daily>){
         // forecastList.clear()
       //  forecastList.(newHourlyList)
        notifyDataSetChanged()
    }

    class DailyViewHolder(var view: ForecastWeatherHourlyItemBinding) :
        RecyclerView.ViewHolder(view.root) {
        private val imageview = view.imgForecastItem


        fun bind(forecast: Daily) {

            view.tvForecastState.text=forecast.weather.get(0).description
            view.tvForecastTemp.text = (Math.round(forecast.temp.day)).toString()
            view.tvForecastHumidity.text= (Math.round(forecast.humidity)).toString()
            view.tvForecastPressure.text= (Math.round(forecast.pressure)).toString()
            view.tvForecastTime.text= dayConverter((forecast.dt).toLong())
            view.tvForecastFeelsTemp.text=(Math.round(forecast.feelsLike.day)).toString()
            view.tvForecastWind.text=(Math.round(forecast.windSpeed)).toString()



            val url = forecast.weather.get(0).icon
            setImage(imageview, url)


        }
    }


}
