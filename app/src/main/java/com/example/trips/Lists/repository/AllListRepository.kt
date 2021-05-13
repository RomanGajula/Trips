package com.example.trips.Lists.repository

import com.example.trips.Common.api.RetrofitInstance
import com.example.trips.Lists.model.List
import retrofit2.Call

class AllListRepository {
//    companion object {
//        var allList = listOf<List>(
//                List(null, "Все населённые пункты", 355),
//                List(null, "Евангелизм", 25),
//                List(null, "Богослужения", 55),
//                List(null, "Не пройденные населённые пункты", 155)
//        )
//    }

    fun getLists(): Call<MutableList<List>> {
        return RetrofitInstance.api.getLists()
    }
}