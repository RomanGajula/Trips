package com.example.trips.Localities.repository

import com.example.trips.common.api.RetrofitInstance
import com.example.trips.Localities.model.LocalityModel
import retrofit2.Call

class LocalityRepository {
    companion object {
        var allListItem = arrayListOf<LocalityModel>(
            LocalityModel(null, "Аснашаны", 8, "078302019"),
            LocalityModel(null, "Елизоветовка", 7, "078306375"),
            LocalityModel(null, "Добружа", 6, "078309283"),
            LocalityModel(null, "Октябрьское", 10, "078302662"),
            LocalityModel(null, "Палария", 13, "078302341"),
            LocalityModel(null, "Цапок", 15, "078303845"),
            LocalityModel(null, "Баронча", 60, "078308377")
        )
    }

    fun getLocality(): Call<MutableList<LocalityModel>> {
        return RetrofitInstance.api.getLocality()
    }

    fun updateLocality(id: Int, locality: LocalityModel): Call<LocalityModel> {
        return RetrofitInstance.api.updateList(id, locality)
    }

    fun getLocalityById(id: Int): Call<List<LocalityModel>> {
        return RetrofitInstance.api.getLocalityById(id)
    }
}