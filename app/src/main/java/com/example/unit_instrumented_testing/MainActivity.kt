package com.example.unit_instrumented_testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText

    private lateinit var btnSum: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)

        btnSum = findViewById(R.id.btnSum)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnDivide = findViewById(R.id.btnDivide)

        btnSum.setOnClickListener {
            add()
        }
        btnDivide.setOnClickListener {
            divide()
        }
        btnSubtract.setOnClickListener {
            sub()
        }

    }

    private fun add() {
        val first = etFirst.text.toString().toFloat()
        val second = etSecond.text.toString().toFloat()

        val arithmetic = Arithmetic()
        val result: Float = arithmetic.add(first, second)

        val intent = Intent(this@MainActivity, OutputActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }

    private fun sub() {
        val first = etFirst.text.toString().toFloat()
        val second = etSecond.text.toString().toFloat()

        val arithmetic = Arithmetic()
        val result: Float = arithmetic.subtract(first, second)

        val intent = Intent(this@MainActivity, OutputActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }

    private fun divide() {
        val first = etFirst.text.toString().toFloat()
        val second = etSecond.text.toString().toFloat()

        val arithmetic = Arithmetic()
        val result: Float = arithmetic.divide(first, second)

        val intent = Intent(this@MainActivity, OutputActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }
}