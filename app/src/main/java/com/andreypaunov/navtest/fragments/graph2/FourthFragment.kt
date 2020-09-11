package com.andreypaunov.navtest.fragments.graph2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.andreypaunov.navtest.R
import com.andreypaunov.navtest.databinding.FragmentFourthBinding
import com.andreypaunov.navtest.viewmodels.GraphViewModel

class FourthFragment : Fragment() {
    private val graphViewModel: GraphViewModel by navGraphViewModels(R.id.nav_graph2)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentFourthBinding>(inflater, R.layout.fragment_fourth, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        graphViewModel.printCurrentIndex()
    }
}