package com.example.unit_instrumented_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class OutputActivity : AppCompatActivity() {
    private lateinit var tvOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_output)

        tvOutput = findViewById(R.id.tvOutput)
        val extras = intent.extras
        if (!extras!!.isEmpty) {
            val result = extras.getFloat("result").toString()
            tvOutput.text = "Result is : $result"
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show()
        }

    }
}