package com.example.trips.detailsLocaties.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.trips.R
import com.example.trips.databinding.ActivityDetaliesLocalitiesBinding
import com.example.trips.detailsLocaties.viewModel.DetailsViewModel
import com.example.trips.localities.model.LocalityModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetaliesLocalities : AppCompatActivity(), KoinComponent {

    private val detailsViewModel: DetailsViewModel by inject()
    var idDetalies: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetaliesLocalitiesBinding =
                DataBindingUtil.setContentView(
                        this,
                        R.layout.activity_detalies_localities
                )

        idDetalies = intent.getStringExtra("id")

        detailsViewModel.getLocalityById(idDetalies?.toInt()!!).enqueue(object : Callback<List<LocalityModel>> {
            override fun onFailure(call: Call<List<LocalityModel>>, t: Throwable) {
                println(t)
            }

            @SuppressLint("SetTextI18n")
            override fun onResponse(call: Call<List<LocalityModel>>, response: Response<List<LocalityModel>>) {
                response.body()?.forEach {
                    binding.name.text = it.name
                    binding.valueWorshipServices.text = it.worshipServices.toString()
                    if (it.worshipServices != 0) {
                        binding.dateWorshipServices.text = "(последний раз - ${it.dateWorshipServices})"
                    } else {
                        binding.dateWorshipServices.text = ""
                    }
                    binding.valueEvangelism.text = it.evangelism.toString()
                    if (it.evangelism != 0) {
                        binding.dateEvangelism.text = "(последний раз - ${it.dateEvangelism})"
                    } else {
                        binding.dateEvangelism.text = ""
                    }
                    binding.valueDistance.text = "${it.distance.toString()} км"
                    binding.valuePastor.text = it.tellPastor
                }
            }
        })
    }
}