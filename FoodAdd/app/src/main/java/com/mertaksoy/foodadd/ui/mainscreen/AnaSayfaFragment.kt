package com.mertaksoy.foodadd.ui.mainscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodadd.R
import com.mertaksoy.foodadd.data.model.Menu
import com.mertaksoy.foodadd.databinding.FragmentAnaSayfaBinding

class AnaSayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnaSayfaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnaSayfaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val menuList = arrayListOf(
            Menu(R.drawable.food, "Main Course"),
            Menu(R.drawable.soup, "Soup"),
            Menu(R.drawable.hamburger, "Hamburger"),
            Menu(R.drawable.salad, "Salad"),
            Menu(R.drawable.drink, "Drink"),
            Menu(R.drawable.dessert, "Dessert")
        )

        val menulerAdapter = MenuAdapter(menuList) {
            val action = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToFoodFragment(it)
            findNavController().navigate(action)
        }

        binding.menuRecyclerView.layoutManager =
            GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.menuRecyclerView.adapter = menulerAdapter
        binding.menuRecyclerView.setHasFixedSize(true)
    }
}