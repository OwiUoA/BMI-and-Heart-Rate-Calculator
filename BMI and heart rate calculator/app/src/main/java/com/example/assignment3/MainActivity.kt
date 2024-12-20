package com.example.assignment3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weightInput = findViewById<EditText>(R.id.weight_input)
        val heightInput = findViewById<EditText>(R.id.height_input)
        val calculateButton = findViewById<Button>(R.id.calculate_bmi_button)
        val clearButton = findViewById<Button>(R.id.clear_bmi_button)
        val heartRateButton = findViewById<Button>(R.id.calculate_heart_rate_button)
        val bmiResult = findViewById<TextView>(R.id.bmi_result)
        val bmiMessage = findViewById<TextView>(R.id.bmi_message)

        calculateButton.setOnClickListener {
            val weight = weightInput.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()

            if (weight != null && height != null) {
                val bmi = weight / (height * height) * 703
                val df = DecimalFormat("#.0")
                bmiResult.text = "BMI: ${df.format(bmi)}"
                bmiMessage.text = getBmiMessage(bmi)
            } else {
                bmiResult.text = "Please enter valid numbers"
                bmiMessage.text = ""
            }
        }

        clearButton.setOnClickListener {
            weightInput.text.clear()
            heightInput.text.clear()
            bmiResult.text = ""
            bmiMessage.text = ""
        }

        heartRateButton.setOnClickListener {
            val intent = Intent(this, HeartRateActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getBmiMessage(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi in 18.5..24.9 -> "Normal weight"
            bmi in 25.0..29.9 -> "Overweight"
            else -> "Obese"
        }
    }
}