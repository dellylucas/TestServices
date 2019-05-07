package com.example.testservicesdev.data

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.testservicesdev.Model.Catalog

class CatalogRepository (private val cityDao: CityDao) {

    val allCity: LiveData<List<Catalog>> = cityDao.getAllCities()

    @WorkerThread
    suspend fun insert(catalog: Catalog) {

        cityDao.insert(catalog)
    }

    @WorkerThread
    suspend fun inserts(catalog: List<Catalog>) {

        cityDao.inserts(catalog)
    }
}