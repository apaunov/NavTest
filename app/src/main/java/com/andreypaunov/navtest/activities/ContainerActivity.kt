package com.andreypaunov.navtest.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.andreypaunov.navtest.R
import com.andreypaunov.navtest.databinding.ActivityContainerBinding

class ContainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DataBindingUtil.setContentView<ActivityContainerBinding>(this, R.layout.activity_container)

        title = "Container Activity"
    }
}