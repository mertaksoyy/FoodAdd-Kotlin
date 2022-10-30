package com.mertaksoy.foodlog.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mertaksoy.foodlog.data.model.YemekModel

//işlem ve sorgular burada yapılacak
@Dao
interface YemekDao { //Yapılacak işlemleri burada yapıyoruz

    @Insert
    fun urunEkle(urun: YemekModel)

    @Update
    fun urunGuncelle(urun: YemekModel)


    @Query("SELECT * FROM YEMEKLER_TABLO WHERE urun_tur = :urunTur")
    fun urunlerGetir(urunTur: String): List<YemekModel>?


}