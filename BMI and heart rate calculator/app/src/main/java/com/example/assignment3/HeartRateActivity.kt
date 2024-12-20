package com.example.assignment3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HeartRateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heart_rate)

        val ageInput = findViewById<EditText>(R.id.age_input)
        val calculateHeartRateButton = findViewById<Button>(R.id.calculate_heart_rate_button)
        val clearHeartRateButton = findViewById<Button>(R.id.clear_heart_rate_button)
        val heartRateResult = findViewById<TextView>(R.id.heart_rate_result)

        calculateHeartRateButton.setOnClickListener {
            val age = ageInput.text.toString().toIntOrNull()
            if (age != null) {
                val maxHeartRate = 220 - age
                val targetMin = maxHeartRate * 0.5
                val targetMax = maxHeartRate * 0.85
                heartRateResult.text = "Max HR: $maxHeartRate\nTarget HR Range: ${targetMin.toInt()} - ${targetMax.toInt()} bpm"
            } else {
                heartRateResult.text = "Please enter a valid age"
            }
        }

        clearHeartRateButton.setOnClickListener {
            ageInput.text.clear()
            heartRateResult.text = ""
        }
    }
}