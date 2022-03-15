package com.example.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import com.example.guess.databinding.ActivityMainBinding


/*class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    var secret = (1..100).random()
    var min = 1
    var max = 100
    var chance = 10

    fun reset() {
        secret = (1..100).random()
        min = 1
        max = 100
        chance = 10
        binding.numScope.text = "$min 到$max，請猜"
        binding.chance.text = "剩餘機會：$chance"
    }

    fun usechance() {
        chance--
        binding.chance.text = "剩餘機會：$chance"
        if (chance == 0) {
            binding.talk.text = "你很遜欸 重來好嗎"
            reset()
        }
    }

    fun guess(view: View) {
        println(secret)
        println("Please enter a number(1-100):")

        var num = binding.edNumber.text.toString().toInt()
//        binding.numScope.text.toString()

        if ((num > max) or (num < min)) {
            binding.talk.text = "老大你來亂的喔"
            usechance()
        } else if (num > secret) {
            max = num
            binding.talk.text = "太大了拉"
            binding.numScope.text = "$min 到$max，請猜"
            usechance()
        } else if (num < secret) {
            min = num
            binding.talk.text = "太小了拉"
            binding.numScope.text = "$min 到$max，請猜"
            usechance()
        } else if (num == secret) {
            binding.talk.text = "唉唷猜對了餒"
        }

    }

    fun restart(view: View) {
        reset()
        binding.talk.text = "請開始"
    }
}*/

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
    lateinit var binding: ActivityMainBinding
    val viewModel by viewModels<GuessViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}

