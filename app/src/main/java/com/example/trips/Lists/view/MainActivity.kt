package com.example.trips.Lists.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trips.Lists.adapter.AllListsAdapter
import com.example.trips.R
import com.example.trips.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val allListsAdapter by lazy { AllListsAdapter() }

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
    }
}