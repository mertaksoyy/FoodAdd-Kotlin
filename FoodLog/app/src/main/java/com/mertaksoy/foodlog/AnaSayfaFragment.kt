package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.mertaksoy.foodlog.databinding.FragmentAnaSayfaBinding

class AnaSayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnaSayfaBinding
    //private lateinit var menuList :ArrayList<Menu>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnaSayfaBinding.inflate(layoutInflater)
        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_ana_sayfa, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val menuList = arrayListOf(
            Menu(R.drawable.food, "Ana Yemek"),
            Menu(R.drawable.soup, "Çorba"),
            Menu(R.drawable.burger, "Hamburger"),
            Menu(R.drawable.salad, "Salata"),
            Menu(R.drawable.drink, "İçecek"),
            Menu(R.drawable.icecream, "Tatlı")
        )

        val menulerAdapter = MenuAdapter(menuList) //Adaptera listeyi gönderdik
        //binding.menuRecyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        binding.menuRecyclerView.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        binding.menuRecyclerView.adapter = menulerAdapter
        binding.menuRecyclerView.setHasFixedSize(true)
    }

}