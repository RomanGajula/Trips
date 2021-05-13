package com.example.trips.Common.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.trips.Lists.view.MainActivity
import com.example.trips.Localities.model.LocalityModel
import com.example.trips.Localities.view.Locality
import com.example.trips.Localities.viewModel.LocalityViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddLocalityDialog(id: Int) : DialogFragment(), KoinComponent {


    val localityViewModel: LocalityViewModel by inject()
    private val items = arrayOf("Богослужение", "Евангелизм", "Богослужение и евангелизм", "Очистить существующие данные")
    var checkItem: Boolean = false
    var idLocation: Int = id
    lateinit var location: LocalityModel
    var selectedItem = String()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Куда хотите добавить?")
                    .setSingleChoiceItems(items, -1
                    ) { dialog, item ->
                        checkItem = true
                        selectedItem = items[item]
                        localityViewModel.getLocalityById(idLocation).enqueue(object : Callback<List<LocalityModel>> {
                            override fun onFailure(call: Call<List<LocalityModel>>, t: Throwable) {
                                println(t)
                            }

                            @RequiresApi(Build.VERSION_CODES.R)
                            override fun onResponse(call: Call<List<LocalityModel>>, response: Response<List<LocalityModel>>) {
                                val localityList = response.body()
                                localityList?.forEach {
                                    location = LocalityModel(
                                            it?.id,
                                            it?.name,
                                            it?.distance,
                                            it?.tellPastor,
                                            it?.worshipServices,
                                            it?.evangelism
                                    )
                                }
                            }
                        })
                    }
                    .setPositiveButton("OK"
                    ) { dialog, id ->
                        if (!checkItem) {
                            Toast.makeText(
                                    activity, "Вы ничего не выбрали!",
                                    Toast.LENGTH_LONG
                            ).show()
                        } else {
                            if (selectedItem == "Богослужение") {
                                location.worshipServices = location.worshipServices!! + 1
                            } else if (selectedItem == "Евангелизм") {
                                location.evangelism = location.evangelism!! + 1
                            } else if (selectedItem == "Богослужение и евангелизм") {
                                location.evangelism = location.evangelism!! + 1
                                location.worshipServices = location.worshipServices!! + 1
                            } else if (selectedItem == "Очистить существующие данные") {
                                location.evangelism = 0
                                location.worshipServices = 0
                            }
                            localityViewModel.updateLocality(idLocation,
                                    LocalityModel(
                                            idLocation,
                                            location.name,
                                            location.distance,
                                            location.tellPastor,
                                            location.worshipServices,
                                            location.evangelism)).enqueue(object : Callback<LocalityModel> {
                                override fun onFailure(call: Call<LocalityModel>, t: Throwable) {
                                    println(t)
                                }

                                @RequiresApi(Build.VERSION_CODES.R)
                                override fun onResponse(call: Call<LocalityModel>, response: Response<LocalityModel>) {
                                }
                            })
                        }
                    }
                    .setNegativeButton("Отмена") { dialog, id ->
                    }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}