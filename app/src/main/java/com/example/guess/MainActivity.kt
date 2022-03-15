package com.example.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
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
    val fragment = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragments()
        binding.buttonNavBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_guess -> {
                    supportFragmentManager.beginTransaction().run {
                        replace(R.id.main_container, fragment[0]).commit()
                    }
                    true
                }
                R.id.action_bmi -> {
                    supportFragmentManager.beginTransaction().run {
                        replace(R.id.main_container, fragment[1]).commit()
                    }
                    true
                }
                R.id.action_camera -> {true}
                else -> true

            }
        }

    }
    private fun initFragments() {
        fragment.add(0, GuessFragment())
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.add(R.id.main_container, guess1to10Fragment)
//        transaction.commit()

        fragment.add(1, BmiFragment())

        // kotlin way
        // 當想對建立的物件做某些事，做完物件就無用時可以用 .run {}
        supportFragmentManager.beginTransaction().run{
            add(R.id.main_container, fragment[0])
//            add(R.id.main_container, fragment[1])
            commit()
            Log.d(TAG, "initFragments: $fragment")
        }

        // 當想對建立的物件做某些事，做完物件還會再用時 .apply {}
//        val t = supportFragmentManager.beginTransaction().apply{
//            add(R.id.main_container, guess1to10Fragment)
//            commit()
//        }

    }
}

