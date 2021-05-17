package com.example.trips.list.viewmodel

import androidx.lifecycle.ViewModel
import com.example.trips.list.model.List
import com.example.trips.list.repository.AllListRepository
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call

class AllListsViewModel : ViewModel(), KoinComponent {
    private val repository: AllListRepository by inject()

    fun getLists(): Call<MutableList<List>> {
        return repository.getLists()
    }
}