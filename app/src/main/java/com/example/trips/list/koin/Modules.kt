package com.example.trips.list.koin

import com.example.trips.list.repository.AllListRepository
import com.example.trips.list.viewmodel.AllListsViewModel
import com.example.trips.localities.repository.LocalityRepository
import com.example.trips.localities.viewModel.LocalityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AllListsViewModel() }
    viewModel { LocalityViewModel() }
    single { AllListRepository() }
    single { LocalityRepository() }
}