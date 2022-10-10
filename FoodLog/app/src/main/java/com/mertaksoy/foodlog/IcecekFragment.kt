package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mertaksoy.foodlog.databinding.FragmentIcecekBinding


class IcecekFragment : Fragment() {

    private lateinit var binding: FragmentIcecekBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIcecekBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            val actionIcecekEkle = IcecekFragmentDirections.actionIcecekFragmentToEkleFragment("İçecek")
            Navigation.findNavController(it).navigate(actionIcecekEkle)
        }
    }

}