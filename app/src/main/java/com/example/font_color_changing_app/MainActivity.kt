package com.example.font_color_changing_app
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var fontSize = 20f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtTitle = findViewById<TextView>(R.id.txtTitle)
        val btnFont = findViewById<Button>(R.id.btnFont)
        val btnColor = findViewById<Button>(R.id.btnColor)
        btnFont.setOnClickListener {
            fontSize += 2
            txtTitle.textSize = fontSize
            Toast.makeText(this, "Font size changed", Toast.LENGTH_SHORT).show()
        }

        btnColor.setOnClickListener {
            txtTitle.setTextColor(Color.BLUE)
            Toast.makeText(this, "Text color changed", Toast.LENGTH_SHORT).show()
        }
    }
}
