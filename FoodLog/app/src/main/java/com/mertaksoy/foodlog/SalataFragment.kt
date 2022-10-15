package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodlog.databinding.FragmentSalataBinding
import com.mertaksoy.foodlog.room.YemeklerDataBase


class SalataFragment : Fragment() {
    private lateinit var yemeklerDB : YemeklerDataBase
    private lateinit var binding: FragmentSalataBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSalataBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        yemeklerDB = YemeklerDataBase.getYemeklerDatabase(requireContext())!!


        val yemekList = yemeklerDB.yemekDao.urunlerGetir("Salata")
        if (yemekList != null){
            val urunAdapter = UrunAdapter(yemekList)
            binding.salataRecycler.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.salataRecycler.adapter = urunAdapter
            binding.salataRecycler.setHasFixedSize(true)
        }


        binding.floatingActionButton.setOnClickListener {
            val actionSalataEkle = SalataFragmentDirections.actionSalataFragmentToEkleFragment("Salata")
            Navigation.findNavController(it).navigate(actionSalataEkle)
        }
    }


}