package com.example.testservicesdev.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.testservicesdev.Service.CatalogRepository
import com.example.testservicesdev.Model.Catalog
import com.example.testservicesdev.Service.CityDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatalogViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: CatalogRepository
    var allCity: LiveData<List<Catalog>>
    var lastDate: String? = null


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