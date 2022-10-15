package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodlog.databinding.FragmentBurgerBinding
import com.mertaksoy.foodlog.room.YemeklerDataBase


class BurgerFragment : Fragment() {


    private lateinit var binding: FragmentBurgerBinding
    private lateinit var yemeklerDB : YemeklerDataBase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBurgerBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        yemeklerDB = YemeklerDataBase.getYemeklerDatabase(requireContext())!!


        val yemekList = yemeklerDB.yemekDao.urunlerGetir("Burger")
        if (yemekList != null){
            val urunAdapter = UrunAdapter(yemekList)
            binding.burgerRecycler.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.burgerRecycler.adapter = urunAdapter
            binding.burgerRecycler.setHasFixedSize(true)
        }

        binding.floatingActionButton.setOnClickListener {
            val actionBurgerEkle = BurgerFragmentDirections.actionBurgerFragmentToEkleFragment("Burger")
            Navigation.findNavController(it).navigate(actionBurgerEkle)
        }
    }


}