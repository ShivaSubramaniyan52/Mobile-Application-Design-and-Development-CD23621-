package com.example.a1_b

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var studentCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countText: TextView = findViewById(R.id.countText)
        val checkInButton: Button = findViewById(R.id.btnCheckIn)
        val checkOutButton: Button = findViewById(R.id.btnCheckOut)

        checkInButton.setOnClickListener {
            studentCount++
            countText.text = studentCount.toString()
            Toast.makeText(this, "Student Checked In", Toast.LENGTH_SHORT).show()
        }

        checkOutButton.setOnClickListener {
            if (studentCount > 0) {
                studentCount--
                countText.text = studentCount.toString()
                Toast.makeText(this, "Student Checked Out", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No students inside", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
