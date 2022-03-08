package com.example.guess

import android.content.res.Resources


class NumberGame {
    enum class GameState() {
        INIT, BIGGER, SMALLER, END, BINGO
    }
    var secret = (1..10).random()
    var counter = 0
    var end = false
    fun reset() {
        secret = (1..10).random()
        counter = 0
        end = false
    }
    fun guess(num: Int) : GameState {
        counter++
        val message =
            if (num > secret) GameState.SMALLER
            else if (num < secret) GameState.BIGGER
            else {
            end = true
            GameState.BINGO
            }
        return message
    }
}