package com.hank.bmi

import kotlin.random.Random

class GuessGame {
    enum class Status {
        INIT, BIGGER, SMALLER, BINGO
    }

    var secret: Int = (1..10).random()
    var counter = 0
    var status = Status.INIT

    fun guess(n: Int): Status {
        counter++
        return if (n > secret) Status.SMALLER
        else if (n < secret) Status.BIGGER
        else Status.BINGO
    }

    fun reset() {
        counter = 0
        secret = (1..10).random()
    }

}

fun main() {
    val game = GuessGame()
    val num = 3
    val result = game.guess(num)

}



