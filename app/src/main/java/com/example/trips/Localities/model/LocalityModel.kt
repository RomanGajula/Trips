package com.example.trips.Localities.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "locality")
class LocalityModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null,
    var distance: Int? = null,
    var tellPastor: String? = null
)