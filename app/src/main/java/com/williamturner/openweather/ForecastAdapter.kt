package com.williamturner.openweather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.williamturner.openweather.model.ListElement

class ForecastAdapter(private val context: Context, private val arrayList: ArrayList<ListElement>) : BaseAdapter() {

    private lateinit var mainValue: TextView
    private lateinit var temperature: TextView

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.forecast_list_item, parent, false)
        mainValue = convertView.findViewById(R.id.mainValue)
        temperature = convertView.findViewById(R.id.temperature)

        mainValue.text = arrayList[position].weather[0].main?.value
        temperature.text = arrayList[position].main?.temp.toString()

        return convertView
    }

}