package com.example.trips.detailsLocaties.koin

import com.example.trips.detailsLocaties.repository.DetaliesRepository
import com.example.trips.detailsLocaties.viewModel.DetailsViewModel
import com.example.trips.list.repository.AllListRepository
import com.example.trips.list.viewmodel.AllListsViewModel
import com.example.trips.localities.repository.LocalityRepository
import com.example.trips.localities.viewModel.LocalityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailsAppModule = module {
    viewModel { DetailsViewModel() }
    single { DetaliesRepository() }
}