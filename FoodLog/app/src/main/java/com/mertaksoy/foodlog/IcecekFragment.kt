package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodlog.databinding.FragmentIcecekBinding
import com.mertaksoy.foodlog.room.YemeklerDataBase


class IcecekFragment : Fragment() {
    private lateinit var yemeklerDB : YemeklerDataBase
    private lateinit var binding: FragmentIcecekBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentIcecekBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        yemeklerDB = YemeklerDataBase.getYemeklerDatabase(requireContext())!!


        val yemekList = yemeklerDB.yemekDao.urunlerGetir("İçecek")
        if (yemekList != null){
            val urunAdapter = UrunAdapter(yemekList)
            binding.icecekRecycler.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.icecekRecycler.adapter = urunAdapter
            binding.icecekRecycler.setHasFixedSize(true)
        }



        binding.floatingActionButton.setOnClickListener {
            val actionIcecekEkle = IcecekFragmentDirections.actionIcecekFragmentToEkleFragment("İçecek")
            Navigation.findNavController(it).navigate(actionIcecekEkle)
        }
    }

}