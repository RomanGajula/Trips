package com.example.trips.list.view

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.trips.list.adapter.AllListsAdapter
import com.example.trips.list.model.List
import com.example.trips.list.viewmodel.AllListsViewModel
import com.example.trips.R
import com.example.trips.databinding.ActivityMainBinding
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), KoinComponent {

    // json-server --watch app/src/main/java/com/example/trips/Common/db/db.json --routes app/src/main/java/com/example/trips/Common/db/routes.json

    private val allListsAdapter by lazy { AllListsAdapter() }
    val allListsViewModel: AllListsViewModel by inject()

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

        allListsViewModel.getLists().enqueue(object : Callback<MutableList<List>> {
            override fun onFailure(call: Call<MutableList<List>>, t: Throwable) {
                println(t)
            }

            @RequiresApi(Build.VERSION_CODES.R)
            override fun onResponse(call: Call<MutableList<List>>, response: Response<MutableList<List>>) {
                val allList = response.body()
                allList?.let { allListsAdapter.setData(it.toMutableList()) }
            }
        })
    }
}