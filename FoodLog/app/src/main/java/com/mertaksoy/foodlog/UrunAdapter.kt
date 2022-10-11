package com.mertaksoy.foodlog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mertaksoy.foodlog.databinding.UrunCardTasarimBinding
import com.mertaksoy.foodlog.room.YemekModel

class UrunAdapter(private var yemekList: List<YemekModel>):RecyclerView.Adapter<UrunAdapter.UrunCardTasarim>() {


    class UrunCardTasarim( var urunCardTasarimBinding : UrunCardTasarimBinding):RecyclerView.ViewHolder(urunCardTasarimBinding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrunCardTasarim {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding = UrunCardTasarimBinding.inflate(layoutInflater,parent,false)
        return UrunCardTasarim(binding)
    }


    override fun onBindViewHolder(holder: UrunCardTasarim, position: Int) {
        val yemek = yemekList[position]
        holder.urunCardTasarimBinding.yemekAditextView.text = yemek.urunAd
        holder.urunCardTasarimBinding.restoranAditextView.text = yemek.restoranAd
        holder.urunCardTasarimBinding.puanTextView.text = yemek.urunPuan.toString()

    }



    override fun getItemCount() = yemekList.size





}