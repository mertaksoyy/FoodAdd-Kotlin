package com.mertaksoy.foodadd.ui.mainscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mertaksoy.foodadd.data.model.Menu
import com.mertaksoy.foodadd.databinding.MenuCardTasarimBinding

class MenuAdapter(
    private var menuList: ArrayList<Menu>,
    private val onMenuItemClick: (Menu) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuCardTasarim>() {

    inner class MenuCardTasarim(private val binding: MenuCardTasarimBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(menuItem: Menu) {
            with(binding) {
                menuimageView.setImageResource(menuItem.menuGorsel)
                yemekTurTextView.text = menuItem.menuTur
                itemView.setOnClickListener {
                    onMenuItemClick(menuItem)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCardTasarim {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MenuCardTasarimBinding.inflate(layoutInflater, parent, false)
        return MenuCardTasarim(binding)
    }

    override fun onBindViewHolder(holder: MenuCardTasarim, position: Int) =
        holder.bind(menuList[position])

    override fun getItemCount() = menuList.size

}