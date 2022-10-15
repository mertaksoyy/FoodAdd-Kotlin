package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodlog.databinding.FragmentTatliBinding
import com.mertaksoy.foodlog.room.YemeklerDataBase


class TatliFragment : Fragment() {

    private lateinit var yemeklerDB : YemeklerDataBase
    private lateinit var binding: FragmentTatliBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTatliBinding.inflate(layoutInflater)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        yemeklerDB = YemeklerDataBase.getYemeklerDatabase(requireContext())!!


        val yemekList = yemeklerDB.yemekDao.urunlerGetir("Tatlı")
        if (yemekList != null){
            val urunAdapter = UrunAdapter(yemekList)
            binding.tatliRecycler.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.tatliRecycler.adapter = urunAdapter
            binding.tatliRecycler.setHasFixedSize(true)
        }


        binding.floatingActionButton.setOnClickListener {
            val actionTatliEkle = TatliFragmentDirections.actionTatliFragmentToEkleFragment("Tatlı")
            Navigation.findNavController(it).navigate(actionTatliEkle)
        }
    }
}