package com.example.trips.common.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.trips.list.view.MainActivity

class CancelDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Вы уверены, что хотите отменить?")
                    .setCancelable(true)
                    .setPositiveButton("Отмена") { dialog, id ->
                    }
                    .setNegativeButton("Yes",
                            DialogInterface.OnClickListener { dialog, id ->
                                val intent = Intent(context, MainActivity::class.java)
                                startActivity(intent)
                            })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}