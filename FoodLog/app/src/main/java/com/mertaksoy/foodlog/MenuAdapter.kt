package com.mertaksoy.foodlog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.mertaksoy.foodlog.databinding.MenuCardTasarimBinding

class MenuAdapter(private var menuList:ArrayList<Menu>):RecyclerView.Adapter<MenuAdapter.MenuCardTasarim>() {



    class MenuCardTasarim( var MenuCardTasarimBinding : MenuCardTasarimBinding):RecyclerView.ViewHolder(MenuCardTasarimBinding.root)


    /*inner class MenuCardTasarim() : RecyclerView.ViewHolder(){ //üst klastan erişim izni veriyor.

        fun bind(item:Menu){
            menuList
        }
    }
*/
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuCardTasarim {
       val layoutInflater = LayoutInflater.from(parent.context)
        val MenuCardTasarimBinding = MenuCardTasarimBinding.inflate(layoutInflater,parent,false)
        return MenuCardTasarim(MenuCardTasarimBinding)
    }


    override fun onBindViewHolder(holder: MenuCardTasarim, position: Int) {
        val menu = menuList[position]


        holder.MenuCardTasarimBinding.menuimageView.setImageResource(menu.menuGorsel)
        holder.MenuCardTasarimBinding.yemekTurtextView.text = menu.menuTur
        //holder.bind(menuList[position])


        holder.itemView.setOnClickListener {

            if (menu.menuTur == "Ana Yemek")
            {
                val acitonAnaYemek = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToAnaYemekFragment()
                Navigation.findNavController(it).navigate(acitonAnaYemek)
            }
            else if (menu.menuTur == "Çorba")
            {
              val actionCorba = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToCorbaFragment()
              Navigation.findNavController(it).navigate(actionCorba)
            }
            else if (menu.menuTur == "Hamburger")
            {
                val actionHamburger = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToBurgerFragment()
                Navigation.findNavController(it).navigate(actionHamburger)
            }
            else if (menu.menuTur == "Salata")
            {
                val actionSalata = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToSalataFragment()
                Navigation.findNavController(it).navigate(actionSalata)
            }
            else if (menu.menuTur == "İçecek")
            {
                val actionIcecek = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToIcecekFragment()
                Navigation.findNavController(it).navigate(actionIcecek)
            }
            else if(menu.menuTur == "Tatlı")
            {
                val actionTatli = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToTatliFragment()
                Navigation.findNavController(it).navigate(actionTatli)
            }


            /*else{
                val actionCorba = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToCorbaFragment()
                Navigation.findNavController(it).navigate(actionCorba)
            }

            val actionCorba = AnaSayfaFragmentDirections.actionAnaSayfaFragmentToCorbaFragment()
            Navigation.findNavController(it).navigate(actionCorba)

             */
        }

    }

    override fun getItemCount() = menuList.size

}