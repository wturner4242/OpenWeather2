package com.williamturner.openweather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.williamturner.openweather.viewmodel.SharedViewModel

class CitySelectFragment : Fragment() {
    val sharedVM = SharedViewModel()

    lateinit var button: Button
    lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

    // inflate your view here
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_city_select, container, false)


    // Wait until your View is guaranteed not null to grab View elements
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Open Weather"

        // find your view elements and do stuff here
        editText = getView()!!.findViewById(R.id.cityEditText)
        button = getView()!!.findViewById(R.id.lookUpButton)

        button.setOnClickListener {
            val textInput = editText.text.toString()
            // here text input is passed to ForecastFragment using action/nav args
            var action = CitySelectFragmentDirections.actionCitySelectFragmentToForecastFragment(textInput)
            findNavController().navigate(action)
            editText.text.clear()
        }

    }

}