package com.example.trips.common.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.example.trips.Lists.repository.AllListRepository
import com.example.trips.Localities.model.LocalityModel
import com.example.trips.Localities.viewModel.LocalityViewModel
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AddLocalityDialog(id: Int) : DialogFragment(), KoinComponent {

    val localityViewModel: LocalityViewModel by inject()
    val allListRepository: AllListRepository by inject()
    private val items = arrayOf(
            allListRepository.worshipServices,
            allListRepository.evangelism,
            allListRepository.worshipServicesOrEvangelism,
            allListRepository.clearDate)
    var checkItem: Boolean = false
    var idLocation: Int = id
    var location = LocalityModel()
    var selectedItem = String()

    companion object {
        var year = 0
        var month = 0
        var day = 0
    }

    var date = DateDialog()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Куда хотите добавить?")
                    .setSingleChoiceItems(items, -1
                    ) { dialog, item ->
                        checkItem = true
                        selectedItem = items[item]
                        callGetLocalityById(idLocation, location)
                        if (items[item] != allListRepository.clearDate) {
                            date.show(it.supportFragmentManager, "DateDialog")
                        }
                    }
                    .setPositiveButton("OK"
                    ) { dialog, id ->
                        if (!checkItem) {
                            Toast.makeText(
                                    activity, "Вы ничего не выбрали!",
                                    Toast.LENGTH_LONG
                            ).show()
                        } else {
                            checkIfElse()
                            callUpdateLocality(idLocation, location)
                        }
                    }
                    .setNegativeButton("Отмена") { dialog, id ->
                    }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    fun checkIfElse() {
        when (selectedItem) {
            allListRepository.worshipServices -> {
                location.dateWorshipServices = "${day}.${month}.${year}"
            }
            allListRepository.evangelism -> {
                location.dateEvangelism = "${day}.${month}.${year}"
            }
            allListRepository.worshipServicesOrEvangelism -> {
                location.dateEvangelism = "${day}.${month}.${year}"
                location.dateWorshipServices = "${day}.${month}.${year}"
            }
        }
        when (selectedItem) {
            allListRepository.worshipServices -> {
                location.worshipServices = location.worshipServices!! + 1
            }
            allListRepository.evangelism -> {
                location.evangelism = location.evangelism!! + 1
            }
            allListRepository.worshipServicesOrEvangelism -> {
                location.evangelism = location.evangelism!! + 1
                location.worshipServices = location.worshipServices!! + 1
            }
            allListRepository.clearDate -> {
                location.evangelism = 0
                location.worshipServices = 0
                location.dateWorshipServices = ""
                location.dateEvangelism = ""
            }
        }
    }

    fun callGetLocalityById(id: Int, location: LocalityModel) {
        localityViewModel.getLocalityById(id).enqueue(object : Callback<List<LocalityModel>> {
            override fun onFailure(call: Call<List<LocalityModel>>, t: Throwable) {
                println(t)
            }

            @SuppressLint("SetTextI18n")
            @RequiresApi(Build.VERSION_CODES.R)
            override fun onResponse(call: Call<List<LocalityModel>>, response: Response<List<LocalityModel>>) {
                val localityList = response.body()
                localityList?.forEach {
                    location.id = it.id
                    location.name = it.name
                    location.distance = it.distance
                    location.tellPastor = it.tellPastor
                    location.worshipServices = it.worshipServices
                    location.evangelism = it.evangelism
                    location.dateWorshipServices = it.dateWorshipServices
                    location.dateEvangelism = it.dateEvangelism
                }
                DetailsLocationDialog.title.text = location.name
                DetailsLocationDialog.evangelism.text = "${allListRepository.evangelism}: ${location.evangelism.toString()}"
                DetailsLocationDialog.distance.text = "Дистанция: ${location.distance.toString()}"
                DetailsLocationDialog.worshipServices.text = "${allListRepository.worshipServices}: ${location.worshipServices.toString()}"
            }
        })
    }

    fun callUpdateLocality(id: Int, location: LocalityModel) {
        localityViewModel.updateLocality(id,
                LocalityModel(
                        id,
                        location.name,
                        location.distance,
                        location.tellPastor,
                        location.worshipServices,
                        location.evangelism,
                        location.dateWorshipServices,
                        location.dateEvangelism)).enqueue(object : Callback<LocalityModel> {
            override fun onFailure(call: Call<LocalityModel>, t: Throwable) {
                println(t)
            }

            @RequiresApi(Build.VERSION_CODES.R)
            override fun onResponse(call: Call<LocalityModel>, response: Response<LocalityModel>) {
            }
        })
    }

}
