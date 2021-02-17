package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OutputActivity : AppCompatActivity() {
    var bmiIndex: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        val userName = intent.getStringExtra("userName")
        val displayUserName = findViewById<TextView>(R.id.userName)
        displayUserName.setText(userName)

        val btn = findViewById<Button>(R.id.btnCalculate)

        btn.setOnClickListener{
            val weight = findViewById<TextView>(R.id.inputWeight).text.toString()
            val height = findViewById<TextView>(R.id.inputHeight).text.toString()
            val status = findViewById<TextView>(R.id.displayStatus)

            bmiIndex = weight.toDouble() / (height.toDouble() * height.toDouble())

            status.setText(getStatus())
        }

        if(savedInstanceState != null) {
            bmiIndex = savedInstanceState.getDouble("bmiIndex")

            if (bmiIndex != 0.0) {
                val status = findViewById<TextView>(R.id.displayStatus)
                status.setText(getStatus())
            }
        }
    }

    fun getStatus():String{
        if (bmiIndex < 18.5)
            return "Underweight"
        else if (bmiIndex <= 24.9)
            return "Normal weight"
        else if (bmiIndex <= 29.9)
            return "Overweight"
        else if (bmiIndex <= 34.9)
            return "Obesity class 1"
        else if (bmiIndex <= 39.9)
            return "Obesity class 2"
        else return "Obesity class 3"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex", bmiIndex)
    }

}