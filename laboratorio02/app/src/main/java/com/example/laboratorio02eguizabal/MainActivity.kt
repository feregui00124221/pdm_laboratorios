package com.example.laboratorio02eguizabal

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private lateinit var weightEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var BMITextView: TextView
    private lateinit var resultTextView: TextView
    private lateinit var infoTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bind()

        setListener()
    }

    private fun bind() {
        weightEditText = findViewById(R.id.weight_edit_text)
        heightEditText = findViewById(R.id.height_edit_text)
        calculateButton = findViewById(R.id.action_calculate)
        BMITextView = findViewById(R.id.bmi_text_view)
        resultTextView = findViewById(R.id.result_text_view)
        infoTextView = findViewById(R.id.info_text_view)
    }

    private fun setListener() {
        calculateButton.setOnClickListener{
            val lweight = weightEditText.text.toString()
            val lhegiht = heightEditText.text.toString()

            if(!validateInput(lweight, lhegiht)){
                clearTextView()

                return@setOnClickListener
            }

            val lbmi = calculateBMI(lweight.toFloat(), lhegiht.toFloat())

            val bmiToDigits = String.format("%.2f", lbmi).toFloat()

            clearFocus()
            displayResult(bmiToDigits)
        }
    }

    private fun validateInput(weight: String?, height: String?): Boolean {
        when {
            weight.isNullOrEmpty() -> {
                Toast.makeText(this, "Weight is empty", Toast.LENGTH_SHORT).show()
                return false
            }
            height.isNullOrEmpty() -> {
                Toast.makeText(this, "Height is empty", Toast.LENGTH_SHORT).show()
                return false
            }
        }

        return true
    }

    private fun calculateBMI(weight: Float, height: Float): Float {
        return weight/((height/100) * (height/100))
    }

    private fun displayResult(bmi:Float) {
        BMITextView.text = bmi.toString()

        infoTextView.text = "(Normal range is 18.80 -24.9)"

        var informationResult = ""
        var color = 0

        when {
            bmi < 18.5 -> {
                informationResult = "Underweight"
                color = R.color.under_weight
            }

            bmi in 18.5..24.99 -> {
                informationResult = "Healthy"
                color = R.color.normal_weight
            }

            bmi in 25.0..29.99 -> {
                informationResult = "Overweight"
                color = R.color.over_weight
            }

            bmi > 30.00 -> {
                informationResult = "Obese"
                color = R.color.obese
            }
        }

        resultTextView.text = informationResult

        resultTextView.setTextColor(ContextCompat.getColor(this, color))
    }

    private fun clearFocus() {
        weightEditText.clearFocus()
        heightEditText.clearFocus()
    }

    private fun clearTextView() {
        BMITextView.text = ""
        resultTextView.text = ""
        infoTextView.text = ""
    }
}