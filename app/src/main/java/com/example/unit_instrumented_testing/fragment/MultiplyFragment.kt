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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MultiplyFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private lateinit var etFirst: EditText
    private lateinit var etSecond: EditText
    private lateinit var btnMultiply: Button
    private lateinit var tvResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_multiply, container, false)
        etFirst = view.findViewById(R.id.etFirstM)
        etSecond = view.findViewById(R.id.etSecondM)
        btnMultiply = view.findViewById(R.id.btnMultiplyM)
        tvResult = view.findViewById(R.id.tvResultM)

        btnMultiply.setOnClickListener {
            val result = etFirst.text.toString().toInt() * etSecond.text.toString().toInt()
            Toast.makeText(requireContext(), result.toString(), Toast.LENGTH_SHORT).show()
            tvResult.text = result.toString()
        }
        return view
    }

}