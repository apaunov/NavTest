package com.andreypaunov.navtest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.andreypaunov.navtest.R
import com.andreypaunov.navtest.databinding.ActivityMainBinding
import com.andreypaunov.navtest.fragments.graph.FirstFragmentDirections

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        title = "Main Activity"
    }
}