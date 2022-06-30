package com.example.yourlifeinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.datepicker.CalendarConstraints
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker: Button = findViewById(R.id.button)
        btnDatePicker.setOnClickListener {

            clickDatePicker()
        }
    }
      fun clickDatePicker() {

        val myCanlendar = Calendar.getInstance()
        val year = myCanlendar.get(Calendar.YEAR)
        val month = myCanlendar.get(Calendar.MONTH)
        val day = myCanlendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog (this,
                DatePickerDialog.OnDateSetListener{view, year,month,dayOfMonth ->

                    Toast.makeText(this, "pickhbhbhber pressed", Toast.LENGTH_LONG).show() },
    year,
    month,
    day).show()


        }




}