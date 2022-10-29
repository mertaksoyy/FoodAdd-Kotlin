package com.mertaksoy.foodlog.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodlog.data.source.local.YemeklerDataBase
import com.mertaksoy.foodlog.databinding.FragmentFoodBinding

class FoodFragment : Fragment() {

    private lateinit var binding: FragmentFoodBinding

    private var foodDB: YemeklerDataBase? = null

    private val args: FoodFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.ivFood.setImageResource(args.menu.menuGorsel)
        foodDB = YemeklerDataBase.getYemeklerDatabase(requireContext())

        val foodList = foodDB?.yemekDao?.urunlerGetir(args.menu.menuTur)

        if (foodList != null) {
            val foodAdapter = UrunAdapter(foodList)
            binding.rvFood.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.rvFood.adapter = foodAdapter
            binding.rvFood.setHasFixedSize(true)

        } else {
            binding.rvFood.visibility = View.GONE
            //binding.tvEmpty.visibility = View.VISIBLE
        }

        binding.floatingActionButton.setOnClickListener {
            val action = FoodFragmentDirections.actionFoodFragmentToEkleFragment(args.menu)
            it.findNavController().navigate(action)
        }


        /*binding.rvFood.setOnClickListener {
            val action = FoodFragmentDirections.actionFoodFragmentToGuncelleFragment()
            it.findNavController().navigate(action)

        }*/


    }
}