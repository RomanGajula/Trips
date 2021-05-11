package com.example.trips.Lists.viewmodel

import androidx.lifecycle.ViewModel
import com.example.trips.Lists.repository.AllListRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class AllListsViewModel : ViewModel(), KoinComponent {
    private val repository: AllListRepository by inject()
    var allList = AllListRepository.allList
}