package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        val btnEnter = findViewById<View>(R.id.btnEnter)

        btnEnter.setOnClickListener() {
            val intent = Intent(this, OutputActivity::class.java)

            val userName = findViewById<TextView>(R.id.inputName).text
            intent.putExtra("userName", userName.toString())

            startActivity(intent)
        }
    }
}