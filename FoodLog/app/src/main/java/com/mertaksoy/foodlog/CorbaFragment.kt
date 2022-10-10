package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mertaksoy.foodlog.databinding.FragmentCorbaBinding

class CorbaFragment : Fragment() {



    private lateinit var binding: FragmentCorbaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCorbaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener {
            val actionCorbaEkle = CorbaFragmentDirections.actionCorbaFragmentToEkleFragment("Corba")
            Navigation.findNavController(it).navigate(actionCorbaEkle)
        }
    }

}