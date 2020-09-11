package com.andreypaunov.navtest.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class GraphViewModel: ViewModel() {
    private val list = arrayListOf("Apples", "Oranges", "Bananas", "Pears", "Apricots")

    var currentIndex = 0

    fun printCurrentIndex() {
        Log.d("====", "printCurrentIndex: ${list[currentIndex]}")
    }
}