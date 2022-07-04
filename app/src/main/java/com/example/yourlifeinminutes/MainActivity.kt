package com.example.yourlifeinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.datepicker.CalendarConstraints
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private var tvSelectedDate : TextView? = null
    private var yourlife : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.button)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        yourlife = findViewById(R.id.yourlife)
        btnDatePicker.setOnClickListener {

            clickDatePicker()
        }
    }
      private fun clickDatePicker() {

        val myCanlendar = Calendar.getInstance()
        val year = myCanlendar.get(Calendar.YEAR)
        val month = myCanlendar.get(Calendar.MONTH)
        val day = myCanlendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog (this,
            { view, selectedYear, selectedMonth, selectedDayOfMonth ->

                Toast.makeText(this, "$selectedDayOfMonth / ${selectedMonth + 1} / $selectedYear is selected", Toast.LENGTH_LONG).show()
                val selectedDate = "$selectedDayOfMonth / ${selectedMonth + 1} / $selectedYear"
                tvSelectedDate?.setText(selectedDate)
                val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
                val theDate = sdf.parse(selectedDate)
                val selectedDateInMinutes = theDate.time /60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDate.time/60000
                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                yourlife?.text = differenceInMinutes.toString()
            },

            year,
            month,
            day)
          dpd.show()

        }




}