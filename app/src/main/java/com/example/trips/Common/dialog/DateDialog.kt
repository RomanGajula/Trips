package com.example.trips.Common.dialog

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.example.trips.R
import java.util.*

class DateDialog : DialogFragment(), DatePickerDialog.OnDateSetListener {
    private var year = 0
    private var month = 0
    private var day = 0

    @SuppressLint("ResourceType")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val calendar = Calendar.getInstance();
        val year = calendar.get(Calendar.YEAR);
        val month = calendar.get(Calendar.MONTH);
        val day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}