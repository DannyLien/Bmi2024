package com.hank.bmi

import kotlin.random.Random

class GuessGame {
    var secret: Int = (1..10).random()
    var counter = 0

    fun guess(n: Int): Int {
        counter++
        return secret - n
    }

    fun reset() {
        secret = (1..10).random()
        counter = 0
    }
}

fun main() {
    val game = GuessGame()
    val num = 3
    val result = game.guess(num)


}



