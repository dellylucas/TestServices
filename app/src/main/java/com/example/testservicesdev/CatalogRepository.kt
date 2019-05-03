package com.example.testservicesdev

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

class CatalogRepository (private val cityDao: CityDao) {

    val allCity: LiveData<List<Catalog>> = cityDao.getAllCities()

    @WorkerThread
    suspend fun insert(catalog: Catalog) {
        cityDao.insert(catalog)
    }
}