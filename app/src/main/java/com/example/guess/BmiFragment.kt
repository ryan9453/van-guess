package com.example.guess

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.guess.databinding.FragmentBmiBinding

class BmiFragment: Fragment() {

    lateinit var binding: FragmentBmiBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBmiBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var weight = binding.edWeight.text.toString().toFloat()
        var height = binding.edWeight.text.toString().toFloat()
        var bmi = weight/(height*height)

        binding.bBmi.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Hi")
                .setMessage("Your BMI is $bmi")
//            .setPositiveButton("cool", null)
                .setPositiveButton("OK") { dialog, which ->
                    binding.edWeight.setText("")
                    binding.edHeight.setText("")
                }
        }
    }
}