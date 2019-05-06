package com.example.testservicesdev

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CityDao {

        @Query("SELECT * from CAT_CITY ORDER BY id ASC")
        fun getAllCities(): LiveData<List<Catalog>>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insert(catalog: Catalog)

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun inserts(catalog: List<Catalog>)

        @Query("DELETE FROM CAT_CITY")
         fun deleteAll()
}