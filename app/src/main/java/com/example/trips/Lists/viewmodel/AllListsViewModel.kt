package com.example.trips.Lists.viewmodel

import androidx.lifecycle.ViewModel
import com.example.trips.Common.api.RetrofitInstance
import com.example.trips.Lists.model.List
import com.example.trips.Lists.repository.AllListRepository
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call

class AllListsViewModel : ViewModel(), KoinComponent {
    private val repository: AllListRepository by inject()

    fun getLists(): Call<MutableList<List>> {
        return repository.getLists()
    }
}