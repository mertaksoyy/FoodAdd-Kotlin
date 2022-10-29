package com.mertaksoy.foodlog.data.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "yemekler_tablo") //sütu kolon işlemleri isimleri vb burada yapılır
data class YemekModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "urun_tur")
    var urunTur: String,

    @ColumnInfo(name = "urun_ad")
    var urunAd: String,

    @ColumnInfo(name = "restoran_ad")
    var restoranAd: String,

    @ColumnInfo(name = "urun_puan")
    var urunPuan: Int

) : Parcelable
