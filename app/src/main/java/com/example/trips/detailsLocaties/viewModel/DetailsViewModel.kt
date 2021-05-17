package com.example.trips.detailsLocaties.viewModel

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trips.common.api.RetrofitInstance
import com.example.trips.detailsLocaties.repository.DetaliesRepository
import com.example.trips.localities.model.LocalityModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call

class DetailsViewModel : ViewModel(), KoinComponent {

    val detaliesRepository: DetaliesRepository by inject()

    fun getLocalityById(id: Int): Call<List<LocalityModel>> {
        return detaliesRepository.getLocalityById(id)
    }

}