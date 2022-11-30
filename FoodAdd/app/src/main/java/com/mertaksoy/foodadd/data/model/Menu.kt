package com.mertaksoy.foodadd.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menu(val menuGorsel: Int, val menuTur: String) : Parcelable