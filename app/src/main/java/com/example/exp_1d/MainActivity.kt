package com.example.exp_1d

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Removed enableEdgeToEdge() to resolve possible rendering issues on some emulators
        setContentView(R.layout.activity_main)

        val tempInput = findViewById<EditText>(R.id.tempInput)
        val unitGroup = findViewById<RadioGroup>(R.id.unitGroup)
        val convertBtn = findViewById<Button>(R.id.convertBtn)
        val resultText = findViewById<TextView>(R.id.resultText)

        convertBtn.setOnClickListener {
            val inputStr = tempInput.text.toString()
            if (inputStr.isEmpty()) {
                Toast.makeText(this, "Please enter a temperature", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val inputTemp = inputStr.toDoubleOrNull()
            if (inputTemp == null) {
                Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val selectedId = unitGroup.checkedRadioButtonId
            if (selectedId == R.id.toCelsius) {
                // Fahrenheit to Celsius
                val result = (inputTemp - 32) * 5 / 9
                resultText.text = String.format(Locale.getDefault(), "%.2f °C", result)
            } else if (selectedId == R.id.toFahrenheit) {
                // Celsius to Fahrenheit
                val result = (inputTemp * 9 / 5) + 32
                resultText.text = String.format(Locale.getDefault(), "%.2f °F", result)
            } else {
                Toast.makeText(this, "Please select a conversion unit", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
