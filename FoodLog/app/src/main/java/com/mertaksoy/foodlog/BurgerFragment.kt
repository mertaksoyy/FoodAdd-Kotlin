package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.mertaksoy.foodlog.databinding.FragmentBurgerBinding


class BurgerFragment : Fragment() {


    private lateinit var binding: FragmentBurgerBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBurgerBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingActionButton.setOnClickListener {
            val actionBurgerEkle = BurgerFragmentDirections.actionBurgerFragmentToEkleFragment("Burger")
            Navigation.findNavController(it).navigate(actionBurgerEkle)
        }
    }


}