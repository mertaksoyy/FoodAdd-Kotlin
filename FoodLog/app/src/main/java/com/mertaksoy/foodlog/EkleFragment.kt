package com.mertaksoy.foodlog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.mertaksoy.foodlog.databinding.FragmentEkleBinding
import com.mertaksoy.foodlog.room.YemekModel
import com.mertaksoy.foodlog.room.YemeklerDataBase


class EkleFragment : Fragment() {
    private val args: EkleFragmentArgs by navArgs()
    private lateinit var yemeklerDB: YemeklerDataBase
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
        //Toast.makeText(requireContext(),args.kategori,Toast.LENGTH_LONG).show()
        yemeklerDB = YemeklerDataBase.getYemeklerDatabase(requireContext())!!


        binding.buttonEkle.setOnClickListener {
            val urunAd = binding.yemekAdeditText.text.toString()
            val urunRestoranAd = binding.restoranAdiEditText.text.toString()
            val urunPuanGirdi = binding.puaneditTextNumber.text.toString()

            if (urunAd.isNotEmpty() && urunRestoranAd.isNotEmpty() && urunPuanGirdi.isNotEmpty()) {
                yemeklerDB.yemekDao.urunEkle(
                    YemekModel(
                        urunTur = args.kategori,
                        urunAd = urunAd,
                        restoranAd = urunRestoranAd,
                        urunPuan = urunPuanGirdi.toInt()

                    )
                )
            } else {
                Toast.makeText(context, "Boş olamaz", Toast.LENGTH_SHORT).show()
            }




        }

    }
}