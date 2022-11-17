package com.mertaksoy.foodlog.ui.splashscreen

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.mertaksoy.foodlog.R
import kotlin.math.log


class SplashFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        object: CountDownTimer(1000, 1000) {

            override fun onTick(millisUntilFinished: Long) { }

            override fun onFinish() {
                val action = SplashFragmentDirections.actionSplashFragmentToAnaSayfaFragment()
                findNavController().navigate(action)
            }
        }.start()

        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


}