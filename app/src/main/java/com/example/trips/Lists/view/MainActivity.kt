package com.example.trips.Lists.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trips.Common.utils.Constants.Companion.BASE_URL
import com.example.trips.Lists.adapter.AllListsAdapter
import com.example.trips.Localities.model.LocalityModel
import com.example.trips.Localities.repository.LocalityRepository
import com.example.trips.Localities.viewModel.LocalityViewModel
import com.example.trips.R
import com.example.trips.databinding.ActivityMainBinding
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), KoinComponent {

    private val allListsAdapter by lazy { AllListsAdapter() }
    val localityViewModel: LocalityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
            )
        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            recyclerView.adapter = allListsAdapter
        }

        val callList: Call<MutableList<LocalityModel>> = localityViewModel.getLocality()
        callList.enqueue(object : Callback<MutableList<LocalityModel>> {
            override fun onFailure(call: Call<MutableList<LocalityModel>>, t: Throwable) {
                println(t)
            }

            @RequiresApi(Build.VERSION_CODES.R)
            override fun onResponse(call: Call<MutableList<LocalityModel>>, response: Response<MutableList<LocalityModel>>) {
                val employee = response.body()
            }
        })


    }
}