package com.example.trips.Common.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.trips.Lists.view.MainActivity
import com.example.trips.Localities.view.Locality

class AddLocalityDialog : DialogFragment() {

    private val items = arrayOf("Богослужение", "Евангелизм", "Богослужение и евангелизм", "Очистить существующие данные")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val selectedItems = ArrayList<Int>() // Where we track the selected items
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Куда хотите добавить?")
                    .setSingleChoiceItems(items, -1
                    ) { dialog, item ->
                        println(items[item])
                    }
                    .setPositiveButton("OK"
                    ) { dialog, id ->
                    }
                    .setNegativeButton("Отмена") {
                        dialog, id ->
                    }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}