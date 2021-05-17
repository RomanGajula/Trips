package com.example.trips.detailsLocaties.repository

import com.example.trips.common.api.RetrofitInstance
import com.example.trips.list.model.List
import com.example.trips.localities.model.LocalityModel
import retrofit2.Call

class DetaliesRepository {

    fun getLocalityById(id: Int): Call<kotlin.collections.List<LocalityModel>> {
        return RetrofitInstance.api.getLocalityById(id)
    }

}