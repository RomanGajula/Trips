package com.example.trips.localities.viewModel

import androidx.lifecycle.ViewModel
import com.example.trips.localities.model.LocalityModel
import com.example.trips.localities.repository.LocalityRepository
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call

class LocalityViewModel: ViewModel(), KoinComponent {
    val localityRepository: LocalityRepository by inject()

    fun getLocality(): Call<MutableList<LocalityModel>> {
        return localityRepository.getLocality()
    }

    fun updateLocality(id: Int, locality: LocalityModel): Call<LocalityModel> {
        return localityRepository.updateLocality(id, locality)
    }

    fun getLocalityById(id: Int): Call<List<LocalityModel>> {
        return localityRepository.getLocalityById(id)
    }
}