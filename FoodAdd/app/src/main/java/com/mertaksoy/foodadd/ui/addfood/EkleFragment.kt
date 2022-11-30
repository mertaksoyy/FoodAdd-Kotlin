package com.mertaksoy.foodadd.ui.addfood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.mertaksoy.foodadd.data.model.YemekModel
import com.mertaksoy.foodadd.data.model.source.local.YemeklerDataBase
import com.mertaksoy.foodadd.databinding.FragmentEkleBinding


class EkleFragment : Fragment() {
    private val args: EkleFragmentArgs by navArgs()
    private var yemeklerDB: YemeklerDataBase? = null
    private lateinit var binding: FragmentEkleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEkleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        yemeklerDB = YemeklerDataBase.getYemeklerDatabase(requireContext())

        var urunPuanGirdi = 0f
        binding.ratingBar.setOnRatingBarChangeListener { _, fl, _ ->
            urunPuanGirdi = fl
        }

        binding.buttonEkle.setOnClickListener {
            val urunAd = binding.yemekAdiEdit.text.toString()
            val urunRestoranAd = binding.restoranAdiEdit.text.toString()
            val urunAdres = binding.restoranAdrestEdit.text.toString()

            if (urunAd.isNotEmpty() && urunRestoranAd.isNotEmpty() && urunAdres.isNotEmpty() && urunPuanGirdi != 0f) {
                yemeklerDB?.yemekDao?.urunEkle(
                    YemekModel(
                        urunTur = args.menu.menuTur,
                        urunAd = urunAd,
                        restoranAd = urunRestoranAd,
                        urunPuan = urunPuanGirdi.toInt(),
                        urunAdres = urunAdres
                    )
                )
                it.findNavController().navigateUp()
            } else {
                Toast.makeText(context, "Boş olamaz", Toast.LENGTH_SHORT).show()
            }
        }
    }
}