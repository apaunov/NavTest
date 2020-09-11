package com.andreypaunov.navtest.fragments.graph

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.andreypaunov.navtest.R
import com.andreypaunov.navtest.databinding.FragmentSecondBinding
import com.andreypaunov.navtest.viewmodels.GraphViewModel

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    private val graphViewModel: GraphViewModel by navGraphViewModels(R.id.nav_graph)

    private var test: String? = null
    private var test2: Int = 0
    private var backTest: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            test = SecondFragmentArgs.fromBundle(it).test
            test2 = SecondFragmentArgs.fromBundle(it).test2
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        binding.textView.text = test
        binding.button.setOnClickListener {
            val action = SecondFragmentDirections.openThirdFragment()

            findNavController().navigate(action)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = findNavController()

        backTest?.let {
            binding.textView.text = it
        }

        navController.currentBackStackEntry?.savedStateHandle?.getLiveData<String>("key")?.observe(viewLifecycleOwner) { result ->
            backTest = result

            Log.d("====", "Second Fragment back result: $result")

            navController.currentBackStackEntry?.savedStateHandle?.remove<String>("key")
        }
    }

    override fun onResume() {
        super.onResume()

        graphViewModel.printCurrentIndex()
    }
}