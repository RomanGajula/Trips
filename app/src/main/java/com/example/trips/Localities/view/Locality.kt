package com.example.trips.Localities.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trips.Localities.adapter.LocalityAdapter
import com.example.trips.Localities.model.LocalityModel
import com.example.trips.Localities.viewModel.LocalityViewModel
import com.example.trips.R
import com.example.trips.databinding.ActivityLocalityBinding
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Locality : AppCompatActivity(), KoinComponent {

    val localityAdapter by lazy { LocalityAdapter() }
    val localityViewModel: LocalityViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLocalityBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_locality
            )
        binding.apply {
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this@Locality)
            recyclerView.adapter = localityAdapter
        }

        val callList: Call<MutableList<LocalityModel>> = localityViewModel.getLocality()
        callList.enqueue(object : Callback<MutableList<LocalityModel>> {
            override fun onFailure(call: Call<MutableList<LocalityModel>>, t: Throwable) {
                println(t)
            }

            @RequiresApi(Build.VERSION_CODES.R)
            override fun onResponse(call: Call<MutableList<LocalityModel>>, response: Response<MutableList<LocalityModel>>) {
                val localityList = response.body()
                localityList?.let { localityAdapter.setData(it.toMutableList(), supportFragmentManager) }
            }
        })
    }
}