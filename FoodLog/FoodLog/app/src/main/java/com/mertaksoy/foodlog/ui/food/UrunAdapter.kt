package com.mertaksoy.foodlog.ui.food

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mertaksoy.foodlog.data.model.YemekModel
import com.mertaksoy.foodlog.databinding.UrunCardTasarimBinding

class UrunAdapter(private var yemekList: List<YemekModel>) :
    RecyclerView.Adapter<UrunAdapter.UrunCardTasarim>() {



    inner class UrunCardTasarim(private val binding: UrunCardTasarimBinding) :
        RecyclerView.ViewHolder(binding.root) {


            fun bind(item: YemekModel) {

                with(binding) {
                    yemekAditextView.text = item.urunAd
                    restoranAditextView.text = item.restoranAd
                    ratingBar.progress = item.urunPuan
                    cardFood.setOnClickListener {
                        val action = FoodFragmentDirections.actionFoodFragmentToGuncelleFragment(item)
                        it.findNavController().navigate(action)
                    }
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrunCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UrunCardTasarimBinding.inflate(layoutInflater, parent, false)
        return UrunCardTasarim(binding)
    }

    override fun onBindViewHolder(holder: UrunCardTasarim, position: Int) = holder.bind(yemekList[position])


    override fun getItemCount() = yemekList.size

}