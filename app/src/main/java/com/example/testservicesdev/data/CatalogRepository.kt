package com.example.testservicesdev.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.testservicesdev.Model.Catalog
import java.lang.reflect.Array

class CatalogRepository (private val cityDao: CityDao) {

    val allCity: LiveData<List<Catalog>> = cityDao.getAllCities()

    @WorkerThread
    suspend fun insert(catalog: Catalog) {

        cityDao.insert(catalog)
    }

    @WorkerThread
    suspend fun inserts(catalog: ArrayList<Catalog>) {

        cityDao.inserts(catalog)
    }
}