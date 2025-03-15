package com.example.pluhinve_01_01

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondScreen : AppCompatActivity() {

    private lateinit var editText1: EditText
    private lateinit var fromSpinner: Spinner
    private lateinit var inSpinner: Spinner
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        editText1 = findViewById(R.id.editText1)
        fromSpinner = findViewById(R.id.spinner1)
        inSpinner = findViewById(R.id.spinner2)
        resultTextView = findViewById(R.id.TextView4)

        ArrayAdapter.createFromResource(
            this,
            R.array.spinner_items,
            android.R.layout.simple_spinner_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fromSpinner.adapter = arrayAdapter
            inSpinner.adapter = arrayAdapter
        }
    }

    fun Result(view: View) {
        val valueString = editText1.text.toString()
        if (valueString.isEmpty()) {
            resultTextView.text = "Поле ввода не заполнено"
        } else {
            val value = valueString.toDouble()
            val fromUnit = fromSpinner.selectedItemPosition
            val toUnit = inSpinner.selectedItemPosition
            val result = ConvertUnits(value, fromUnit, toUnit)
            resultTextView.text = "Результат: $result"
            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, SignIn::class.java)
                intent.putExtra("result", result)
                intent.putExtra("input",value)
                startActivity(intent)
            }, 3000)

        }
    }

    private fun ConvertUnits(input: Double, fromUnit: Int, toUnit: Int): Double {
        val units = doubleArrayOf(1.0, 1000.0, 1000.0 * 1000.0, 1000.0 * 1000.0 * 1000.0)
        return input * units[fromUnit] / units[toUnit]
    }
}
