package com.example.trips.Lists.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "list")
class List(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var name: String? = null,
    var quantity: Int? = null
)