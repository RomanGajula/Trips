package com.example.trips.localities.model

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