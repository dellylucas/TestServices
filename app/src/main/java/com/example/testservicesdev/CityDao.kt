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

        @Insert(onConflict = OnConflictStrategy.ABORT)
        suspend fun insert(catalog: Catalog)

        @Query("DELETE FROM CAT_CITY")
        fun deleteAll()

}