package com.example.trips.common.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.example.trips.localities.model.LocalityModel
import org.koin.core.KoinComponent

class DetailsLocationDialog(id: Int) : DialogFragment(), KoinComponent {

    var idLocality = id
    companion object {
        lateinit var title: String
        lateinit var worshipServices: TextView
        lateinit var evangelism: TextView
        lateinit var dateWorshipServices: TextView
        lateinit var dateEvangelism: TextView
        lateinit var distance: TextView
        lateinit var tellPastor: TextView
        var locality = LocalityModel()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {



            callGetLocalityById()
//            title = TextView(activity)
//            worshipServices = TextView(activity)
//            evangelism = TextView(activity)
//            dateWorshipServices = TextView(activity)
//            dateEvangelism = TextView(activity)
//            distance = TextView(activity)
//            tellPastor = TextView(activity)
            val builder = AlertDialog.Builder(it)
            builder.setCustomTitle(view)
                    .setCancelable(true)
//                    .setView(setDetailsLocationWorshipServices())
//                    .setView(setDetailsLocationWorshipServices())
//                    .setView(setDetailsLocationWorshipEvangelism())
//                    .setView(setDetailsLocationWorshipDistance())
//                    .setView(setDetailsLocationWorshipTelPastor())
                    .setPositiveButton("Назад") { dialog, id ->
                    }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

//    private fun setDetailsLocationTitle() : TextView {
////        title.textSize = 25.0F
////        title.setTextColor(Color.BLACK)
////        title.setTypeface(null, Typeface.BOLD)
////        title.gravity = Gravity.CENTER
//        return binding.root as TextView
//    }

//    private fun setDetailsLocationWorshipServices() : TextView {
//        worshipServices.textSize = 18.0F
//        worshipServices.setTextColor(Color.BLACK)
//        return worshipServices
//    }
//
//    private fun setDetailsLocationWorshipEvangelism() : TextView {
//        evangelism.textSize = 18.0F
//        evangelism.setTextColor(Color.BLACK)
//        return evangelism
//    }
//
//    private fun setDetailsLocationWorshipDistance() : TextView {
//        distance.textSize = 18.0F
//        distance.setTextColor(Color.BLACK)
//        return distance
//    }
//
//    private fun setDetailsLocationWorshipTelPastor() : TextView {
//        tellPastor.textSize = 18.0F
//        tellPastor.setTextColor(Color.BLACK)
//        return tellPastor
//    }
//
    private fun callGetLocalityById() {
        AddLocalityDialog(idLocality).callGetLocalityById(idLocality, locality)
    }
}