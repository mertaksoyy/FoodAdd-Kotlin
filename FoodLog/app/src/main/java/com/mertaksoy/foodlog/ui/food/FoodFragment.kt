package com.mertaksoy.foodlog.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodlog.data.source.local.YemeklerDataBase
import com.mertaksoy.foodlog.databinding.FragmentFoodBinding

class FoodFragment : Fragment() {

    private lateinit var binding: FragmentFoodBinding

    private var foodDB: YemeklerDataBase? = null

    private var foodAdapter = UrunAdapter()

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

       setData()


        binding.backFoodMenu.setOnClickListener {
            val action = FoodFragmentDirections.actionFoodFragmentToAnaSayfaFragment()
            it.findNavController().navigate(action)
        }


        foodAdapter.onMenuItemClick = {
            setFragmentResultListener("Detail") { _, bundle ->
                bundle.getBoolean("isUpdate").let { bool ->
                    if (bool) {
                        setData()
                    }
                }
            }
            val action = FoodFragmentDirections.actionFoodFragmentToGuncelleFragment(it)
            findNavController().navigate(action)
        }

        binding.floatingActionButton.setOnClickListener {
            val action = FoodFragmentDirections.actionFoodFragmentToEkleFragment(args.menu)
            it.findNavController().navigate(action)
        }
    }

    private fun setData() {
        val foodList = foodDB?.yemekDao?.urunlerGetir(args.menu.menuTur)

        if (foodList != null) {
            foodAdapter.updateList(foodList)

            binding.rvFood.layoutManager =
                GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.rvFood.adapter = foodAdapter
            binding.rvFood.setHasFixedSize(true)

        } else {
            binding.rvFood.visibility = View.GONE
        }
    }
}