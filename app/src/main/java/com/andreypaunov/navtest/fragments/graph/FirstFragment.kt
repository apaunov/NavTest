package com.andreypaunov.navtest.fragments.graph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.andreypaunov.navtest.R
import com.andreypaunov.navtest.databinding.FragmentFirstBinding
import com.andreypaunov.navtest.viewmodels.GraphViewModel

class FirstFragment : Fragment() {
    private val graphViewModel: GraphViewModel by navGraphViewModels(R.id.nav_graph)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentFirstBinding>(inflater, R.layout.fragment_first, container, false)

        binding.button.setOnClickListener {
            val action = FirstFragmentDirections.openSecondFragment("From First", 3)

            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        graphViewModel.currentIndex = 2
        graphViewModel.printCurrentIndex()
    }
}