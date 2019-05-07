package com.example.testservicesdev.Service

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.testservicesdev.Model.Catalog
import com.example.testservicesdev.Service.CityDao

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