package com.example.a1_c

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

        val weightEditText: EditText = findViewById(R.id.etWeight)
        val heightEditText: EditText = findViewById(R.id.etHeight)
        val calculateButton: Button = findViewById(R.id.btnCalculate)
        val resultTextView: TextView = findViewById(R.id.tvResult)

        calculateButton.setOnClickListener {

            val weightStr = weightEditText.text.toString()
            val heightStr = heightEditText.text.toString()

            if (weightStr.isEmpty() || heightStr.isEmpty()) {
                Toast.makeText(this, getString(R.string.empty_fields_error), Toast.LENGTH_SHORT).show()
            } else {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()


                val bmi = weight / (height * height)

                resultTextView.text = getString(R.string.bmi_result, bmi)
            }
        }
    }
}
