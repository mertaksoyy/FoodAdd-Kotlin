package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mertaksoy.foodlog.databinding.FragmentSalataBinding


class SalataFragment : Fragment() {

    private lateinit var binding: FragmentSalataBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSalataBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {
            val actionSalataEkle = SalataFragmentDirections.actionSalataFragmentToEkleFragment("Salata")
            Navigation.findNavController(it).navigate(actionSalataEkle)
        }
    }


}