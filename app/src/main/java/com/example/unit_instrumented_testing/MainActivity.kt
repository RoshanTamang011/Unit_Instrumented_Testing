package com.example.unit_instrumented_testing

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var btnSum: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnDivide: Button

    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etFirst = findViewById(R.id.etFirst)
        etSecond = findViewById(R.id.etSecond)

        btnSum = findViewById(R.id.btnSum)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnDivide = findViewById(R.id.btnDivide)
        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        if (!checkSensor())
            return
        else {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }

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

    private fun checkSensor(): Boolean {
        var flag = true
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) == null) {
            flag = false
        }
        return flag
    }

    override fun onSensorChanged(event: SensorEvent?) {
        val values = event!!.values[1]
        btnDivide.text = values.toString()
        if (values < -1.5)
            add()
        else if (values > 1.5)
            sub()
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    private fun add() {
        val first = etFirst.text.toString().toFloat()
        val second = etSecond.text.toString().toFloat()

        val arithmetic = Arithmetic()
        val result: Float = arithmetic.add(first, second)
        Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_SHORT).show()
//        val intent = Intent(this@MainActivity, OutputActivity::class.java)
//        intent.putExtra("result", result)
//        startActivity(intent)
    }

    private fun sub() {
        val first = etFirst.text.toString().toFloat()
        val second = etSecond.text.toString().toFloat()

        val arithmetic = Arithmetic()
        val result: Float = arithmetic.subtract(first, second)
        Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_SHORT).show()

//        val intent = Intent(this@MainActivity, OutputActivity::class.java)
//        intent.putExtra("result", result)
//        startActivity(intent)
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