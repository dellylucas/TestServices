package com.example.testservicesdev.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class catalogsCity(
   // @SerializedName("cities")
    val cities: ArrayList<Catalog>)

@Entity(tableName = "CAT_CITY")
data class Catalog (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int,
    @ColumnInfo(name = "city")
    @SerializedName("city")
    var city: String?,
    @ColumnInfo(name = "date_City")
    @SerializedName("dateCity")
    var dateCity: String?

){

    companion object{
        const val TABLE_NAME = "CAT_NATION"
        const val NATI_ID_COLUM_NAME = "NATION_ID"
        const val NAME_NATI_COLUM_NAME = "NAME_NATION"

        /*  const val SERIALIZED_TABLE_NAME = "tabla"
          const val SERIALIZED_NATI_ID_COLUM_NAME = "id"
          const val SERIALIZED_NAME_NATI_COLUM_NAME = "descripcion"*/
    }
}


