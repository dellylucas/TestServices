package com.example.testservicesdev

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatalogViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: CatalogRepository
    var allCity: LiveData<List<Catalog>>

    init {
        val cityDao = CityDatabase.getDatabase(application).cityDao ()
        repository = CatalogRepository(cityDao)
        allCity = repository.allCity
    }

    fun insert(catalog: Catalog) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(catalog)
    }

    fun inserts(catalog: List<Catalog>) = viewModelScope.launch(Dispatchers.IO) {
        repository.inserts(catalog)
    }
}