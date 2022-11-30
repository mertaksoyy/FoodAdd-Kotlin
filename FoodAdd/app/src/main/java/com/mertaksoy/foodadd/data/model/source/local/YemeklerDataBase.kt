package com.mertaksoy.foodadd.data.model.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mertaksoy.foodadd.data.model.YemekModel


@Database(entities = [YemekModel::class], version = 1, exportSchema = false)

abstract class YemeklerDataBase : RoomDatabase() {

    abstract val yemekDao: YemekDao

    companion object {
        @Volatile
        private var INSTANCE: YemeklerDataBase? = null


        fun getYemeklerDatabase(context: Context): YemeklerDataBase? {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) { //eğer bundan önce oluşmamışsa bir veri tabanı oluştur

                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        YemeklerDataBase::class.java,
                        "yemekler_database"
                    ).allowMainThreadQueries().build()

                    INSTANCE = instance
                }
                return INSTANCE
            }

        }

    }

}