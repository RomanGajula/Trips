package com.example.trips.Localities.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class LocalityModel(
        var id: Int? = null,
        var name: String? = null,
        var distance: Int? = null,
        var tellPastor: String? = null,
        var worshipServices: Int? = 0,
        var evangelism: Int? = 0,
        var dateWorshipServices: String? = null,
        var dateEvangelism: String? = null
)