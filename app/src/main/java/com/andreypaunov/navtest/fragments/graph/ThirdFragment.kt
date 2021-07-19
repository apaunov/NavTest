package com.andreypaunov.navtest.fragments.graph

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.andreypaunov.navtest.R
import com.andreypaunov.navtest.databinding.FragmentThirdBinding
import com.andreypaunov.navtest.viewmodels.GraphViewModel

class ThirdFragment: Fragment() {
    private val graphViewModel: GraphViewModel by navGraphViewModels(R.id.nav_graph)
    private lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentThirdBinding>(inflater, R.layout.fragment_third, container, false)

        navController = findNavController()

        binding.button.setOnClickListener {
            val action = ThirdFragmentDirections.openFirstFragment()

            navController.navigate(action)
        }

        binding.backData.setOnClickListener {
            Log.d("====", "backData clicked")

            navController.previousBackStackEntry?.savedStateHandle?.set("key", "Result from Third Fragment")
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        graphViewModel.printCurrentIndex()
    }
}