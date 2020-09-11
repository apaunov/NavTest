package com.andreypaunov.navtest.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.andreypaunov.navtest.R
import com.andreypaunov.navtest.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivitySecondBinding>(this, R.layout.activity_second)

        title = "Second Activity"

        val graphId = intent.extras?.get("gID") as Int

        if (graphId == 1) {
            val navHost2 = NavHostFragment.create(R.navigation.nav_graph2)

            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, navHost2).setPrimaryNavigationFragment(navHost2).commit()
        }
    }
}