package com.example.unit_instrumented_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.unit_instrumented_testing.fragment.MultiplyFragment
import com.example.unit_instrumented_testing.fragment.SumFragment

class LoadFragmentActivity : AppCompatActivity() {
    private lateinit var btnSum: Button
    private lateinit var btnMult: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_fragment_activity)

        btnSum = findViewById(R.id.btnSum)
        btnMult = findViewById(R.id.btnMult)

        loadSum()

        btnSum.setOnClickListener {
            loadSum()
        }

        btnMult.setOnClickListener {
            loadMultiply()
        }

    }

    fun loadSum() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.parentLayout, SumFragment())
            addToBackStack(null)
            commit()
        }
    }

    fun loadMultiply() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.parentLayout, MultiplyFragment())
            addToBackStack(null)
            commit()
        }
    }

}