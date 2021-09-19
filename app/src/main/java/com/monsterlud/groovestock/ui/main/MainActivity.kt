package com.monsterlud.groovestock.ui.main

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.monsterlud.groovestock.App
import com.monsterlud.groovestock.R
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}