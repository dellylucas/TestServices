package com.example.testservicesdev.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class catalogsCity(
    @SerializedName("cities")
    val cities: ArrayList<Catalog>)

@Entity(tableName = "CAT_CITY")
data class Catalog (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @ColumnInfo(name = "city")
    @SerializedName("city")
    val city: String?,
    @ColumnInfo(name = "date_City")
    @SerializedName("dateCity")
    val dateCity: String?

)


