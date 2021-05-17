package com.example.trips.list.repository

import com.example.trips.common.api.RetrofitInstance
import com.example.trips.list.model.List
import retrofit2.Call

class AllListRepository {
    var worshipServices = "Богослужение"
    var evangelism = "Евангелизм"
    var worshipServicesOrEvangelism = "Богослужение и евангелизм"
    var clearDate = "Очистить существующие данные"

    fun getLists(): Call<MutableList<List>> {
        return RetrofitInstance.api.getLists()
    }
}