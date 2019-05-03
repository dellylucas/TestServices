package com.example.testservicesdev

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CAT_CITY")
data class Catalog (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "city") val city: String?,
    @ColumnInfo(name = "date_City") val dateCity: String?
)