package com.example.testservicesdev

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testservicesdev.Model.Catalog


@Database(entities = [Catalog::class], version = 1)
 abstract class CityDatabase : RoomDatabase() {

    abstract fun cityDao(): CityDao

    companion object {
        @Volatile
        private var INSTANCE: CityDatabase? = null

        fun getDatabase(context: Context//, scope: CoroutineScope
        ): CityDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CityDatabase::class.java,
                    "Test_DB"
                )//.addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
/*
        private class WordDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                       // populateDatabase(database.cityDao())
                    }
                }
            }

            suspend fun populateDatabase(cityDao: CityDao) {

                var word = Catalog(1,"Bogota","1556916483")
                cityDao.insert(word)
                word = Catalog(2,"Medellin","1556916483")
                cityDao.insert(word)
            }
        }*/
    }
}