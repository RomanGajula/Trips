package com.example.trips.Localities.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trips.Localities.adapter.LocalityAdapter
import com.example.trips.R
import com.example.trips.databinding.ActivityLocalityBinding

class Locality : AppCompatActivity() {

    val localityAdapter by lazy { LocalityAdapter() }

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
    }
}