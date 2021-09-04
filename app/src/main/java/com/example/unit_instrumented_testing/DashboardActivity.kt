package com.example.unit_instrumented_testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {
    private lateinit var btnUnitTesting: Button
    private lateinit var btnInstrumentedTesting: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnUnitTesting = findViewById(R.id.btnUnitTesting)
        btnInstrumentedTesting = findViewById(R.id.btnInstrumentedTesting)

        btnUnitTesting.setOnClickListener {
            startActivity(Intent(this@DashboardActivity,MainActivity::class.java))
        }

        btnInstrumentedTesting.setOnClickListener {
            startActivity(Intent(this@DashboardActivity,LoadFragmentActivity::class.java))
        }
    }
}