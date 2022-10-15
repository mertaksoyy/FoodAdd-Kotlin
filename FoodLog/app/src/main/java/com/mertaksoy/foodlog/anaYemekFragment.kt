package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodlog.databinding.FragmentAnaYemekBinding
import com.mertaksoy.foodlog.room.YemeklerDataBase


class AnaYemekFragment : Fragment() {
    private lateinit var binding: FragmentAnaYemekBinding
    private lateinit var yemeklerDB : YemeklerDataBase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAnaYemekBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        yemeklerDB = YemeklerDataBase.getYemeklerDatabase(requireContext())!!

        //bu kısmı her fragmenta yapacağız.
        val yemekList = yemeklerDB.yemekDao.urunlerGetir("Ana Yemek")
        if (yemekList != null){
            val urunAdapter = UrunAdapter(yemekList)
            binding.anaYemekRecycler.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.anaYemekRecycler.adapter = urunAdapter
            binding.anaYemekRecycler.setHasFixedSize(true)
        }

        binding.floatingActionButton.setOnClickListener {
            val actionAnaYemekEkle = AnaYemekFragmentDirections.actionAnaYemekFragmentToEkleFragment("Ana Yemek")
            Navigation.findNavController(it).navigate(actionAnaYemekEkle)
        }


    }
}