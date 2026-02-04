package com.example.a1_d

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tempEditText: EditText = findViewById(R.id.etTemperature)
        val btnToFahrenheit: Button = findViewById(R.id.btnToFahrenheit)
        val btnToCelsius: Button = findViewById(R.id.btnToCelsius)
        val resultTextView: TextView = findViewById(R.id.tvResult)

        btnToFahrenheit.setOnClickListener {
            val temp = tempEditText.text.toString()

            if (temp.isEmpty()) {
                Toast.makeText(this, getString(R.string.please_enter_temperature), Toast.LENGTH_SHORT).show()
            } else {
                val celsius = temp.toFloat()
                val fahrenheit = (celsius * 9 / 5) + 32
                resultTextView.text = getString(R.string.result_fahrenheit, fahrenheit)
            }
        }

        btnToCelsius.setOnClickListener {
            val temp = tempEditText.text.toString()

            if (temp.isEmpty()) {
                Toast.makeText(this, getString(R.string.please_enter_temperature), Toast.LENGTH_SHORT).show()
            } else {
                val fahrenheit = temp.toFloat()
                val celsius = (fahrenheit - 32) * 5 / 9
                resultTextView.text = getString(R.string.result_celsius, celsius)
            }
        }
    }
}
