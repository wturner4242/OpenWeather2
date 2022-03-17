package com.williamturner.openweather

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.williamturner.openweather.model.ListElement
import com.williamturner.openweather.viewmodel.SharedViewModel

class ForecastFragment() : Fragment() , SharedViewModel.RevealCallbacks{

    private val args : ForecastFragmentArgs by navArgs()

    private lateinit var forecastList : ListView
    var adapter: ForecastAdapter? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    // inflate your view here
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_forecast, container, false)

    // Wait until your View is guaranteed not null to grab View elements
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val city : String = args.data
        val sharedVM = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        // find your view elements and do stuff here

        forecastList = view!!.findViewById(R.id.forecastList)
        sharedVM.getOpenWeatherResponse( city,this)

        //change title of actionbar
        (activity as AppCompatActivity).supportActionBar?.title = city

    }

    // call back function for retrofit get request
    override fun onSuccess(value: ArrayList<ListElement>) {

        adapter = ForecastAdapter(context!!, value)
        forecastList.adapter = adapter

        forecastList.setOnItemClickListener { _, _, position, _ ->
            if(position in 0..6){
                println(position.toString())
            }
        }
    }

    // call back function for retrofit get request
    override fun onFailure(throwable: Throwable) {
       // //TODO("Not yet implemented")
    }
}