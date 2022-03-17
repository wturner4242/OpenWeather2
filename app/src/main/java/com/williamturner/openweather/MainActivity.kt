package com.williamturner.openweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {

    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // establish navigation
        val host = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment? ?: return

        navController = host.navController

    }
}