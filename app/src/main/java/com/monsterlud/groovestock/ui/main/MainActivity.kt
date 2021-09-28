package com.monsterlud.groovestock.ui.main


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.monsterlud.groovestock.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView
            = findViewById<BottomNavigationView>(R.id.bottom_nav_menu)
        val navHostFragment
            = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
        val navController
            = navHostFragment?.findNavController()


    }


}