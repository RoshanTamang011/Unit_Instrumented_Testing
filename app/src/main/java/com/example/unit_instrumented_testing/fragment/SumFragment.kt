package com.example.unit_instrumented_testing.fragment

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.unit_instrumented_testing.R

class SumFragment : Fragment(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var sensor: Sensor? = null

    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var btnSum: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sensorManager = requireActivity().getSystemService(AppCompatActivity.SENSOR_SERVICE) as SensorManager

        if (!checkSensor())
            return
        else {
            sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)
            sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_sum, container, false)

        etFirst = view.findViewById(R.id.etFirstF)
        etSecond = view.findViewById(R.id.etSecondF)
        btnSum = view.findViewById(R.id.btnSumF)
        tvResult = view.findViewById(R.id.tvResultF)
        btnSum.setOnClickListener {
            addNumber()
        }
        return view
    }

    private fun addNumber() {
        val result = etFirst.text.toString().toInt() * etSecond.text.toString().toInt()
        Toast.makeText(requireContext(), result.toString(), Toast.LENGTH_SHORT).show()
        tvResult.text = result.toString()
    }

    private fun checkSensor(): Boolean {
        var flag = true
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY) == null) {
            flag = false
        }
        return flag
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        val values = p0!!.values[0]

        if (values <= 4)
            addNumber()

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }


}