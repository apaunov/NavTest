package com.andreypaunov.navtest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.andreypaunov.navtest.R
import com.andreypaunov.navtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        title = "Main Activity"

        val intent = Intent(this, SecondActivity::class.java)

        binding.startGraph.setOnClickListener {
            intent.putExtra("gID", 0)

            startActivity(intent)
        }

        binding.startGraph2.setOnClickListener {
            intent.putExtra("gID", 1)

            startActivity(intent)
        }
    }
}