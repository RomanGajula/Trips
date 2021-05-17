package com.example.trips.detailsLocaties.viewModel

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.core.KoinComponent

class DetailsViewModel : ViewModel(), KoinComponent {
    var name = String()
    var worshipServices = MutableLiveData("")
    var evangelism = MutableLiveData("")
    var dateWorshipServices = MutableLiveData("")
    var dateEvangelism = MutableLiveData("")
    var distance = MutableLiveData("")
    var tellPastor = MutableLiveData("")

    fun setText() {
        name = "Hello"
    }

}