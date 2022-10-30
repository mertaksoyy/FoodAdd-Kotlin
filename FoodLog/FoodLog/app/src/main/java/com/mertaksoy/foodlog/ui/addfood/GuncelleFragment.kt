package com.mertaksoy.foodlog.ui.addfood

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mertaksoy.foodlog.data.model.YemekModel
import com.mertaksoy.foodlog.data.source.local.YemeklerDataBase

import com.mertaksoy.foodlog.databinding.FragmentGuncelleBinding
import com.mertaksoy.foodlog.ui.food.FoodFragmentArgs
import com.mertaksoy.foodlog.ui.food.UrunAdapter


class GuncelleFragment : BottomSheetDialogFragment() {
    private val args: GuncelleFragmentArgs by navArgs()
    private var yemeklerDB: YemeklerDataBase? = null
    private lateinit var binding: FragmentGuncelleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGuncelleBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        yemeklerDB = YemeklerDataBase.getYemeklerDatabase(requireContext())

        binding.yemekAdiEditText.setText(args.foodModel.urunAd)
        binding.restoranAdiEditText.setText(args.foodModel.restoranAd)
        binding.ratingBar.progress = args.foodModel.urunPuan

        var urunPuanGirdi = args.foodModel.urunPuan
        binding.ratingBar.setOnRatingBarChangeListener { _, fl, _ ->
            urunPuanGirdi = fl.toInt()
        }

        binding.buttonGuncelle.setOnClickListener {

            val urunAd = binding.yemekAdiEditText.text.toString()
            val urunRestoranAd = binding.restoranAdiEditText.text.toString()

            if (urunAd.isNotEmpty() && urunRestoranAd.isNotEmpty() && urunPuanGirdi != 0) {
                yemeklerDB?.yemekDao?.urunGuncelle(
                    YemekModel(
                        id = args.foodModel.id,
                        urunTur = args.foodModel.urunTur,
                        urunAd = urunAd,
                        restoranAd = urunRestoranAd,
                        urunPuan = urunPuanGirdi
                    )
                )
                setFragmentResult("Detail", bundleOf("isUpdate" to true))
                findNavController().navigateUp()
            } else {
                Toast.makeText(context, "Lütfen Boş Olan Alanları Doldurunuz.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}