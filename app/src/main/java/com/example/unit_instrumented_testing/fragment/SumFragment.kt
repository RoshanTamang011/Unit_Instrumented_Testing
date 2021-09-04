package com.example.unit_instrumented_testing.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.unit_instrumented_testing.R

class SumFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var btnSum: Button
    private lateinit var tvResult: TextView
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
            val result = etFirst.text.toString().toInt() * etSecond.text.toString().toInt()
            Toast.makeText(requireContext(), result.toString(), Toast.LENGTH_SHORT).show()
            tvResult.text = result.toString()
        }
        return view
    }


}