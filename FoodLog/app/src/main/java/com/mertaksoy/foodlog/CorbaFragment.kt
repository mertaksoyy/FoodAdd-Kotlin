package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodlog.databinding.FragmentCorbaBinding
import com.mertaksoy.foodlog.room.YemeklerDataBase

class CorbaFragment : Fragment() {


    private lateinit var yemeklerDB : YemeklerDataBase
    private lateinit var binding: FragmentCorbaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentCorbaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        yemeklerDB = YemeklerDataBase.getYemeklerDatabase(requireContext())!!


        val yemekList = yemeklerDB.yemekDao.urunlerGetir("Corba")
        if (yemekList != null){
            val urunAdapter = UrunAdapter(yemekList)
            binding.corbaRecycler.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.corbaRecycler.adapter = urunAdapter
            binding.corbaRecycler.setHasFixedSize(true)
        }


        binding.floatingActionButton.setOnClickListener {
            val actionCorbaEkle = CorbaFragmentDirections.actionCorbaFragmentToEkleFragment("Corba")
            Navigation.findNavController(it).navigate(actionCorbaEkle)
        }
    }

}