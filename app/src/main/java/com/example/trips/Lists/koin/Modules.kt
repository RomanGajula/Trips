package com.example.trips.Lists.koin

import com.example.trips.Lists.repository.AllListRepository
import com.example.trips.Lists.viewmodel.AllListsViewModel
import com.example.trips.Localities.repository.LocalityRepository
import com.example.trips.Localities.viewModel.LocalityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { AllListsViewModel() }
    viewModel { LocalityViewModel() }
    single { AllListRepository() }
    single { LocalityRepository() }
}