package com.hank.bmi

import kotlin.random.Random

fun main() {
//    println(Random.nextInt(1, 11))
//    println((1..10).random())

    val secret = (1..10).random()
    println("secret: ${secret}")
    var num = 0
    var bingo = false
    for (i in 1..3) {
        print("Please enter a number(1-10): ")
        val input = readLine()
        num = input?.toIntOrNull() ?: 0
        println("The number you entered: ${num} ")

        if (num < secret) {
            println("Bigger")
        } else if (num > secret) {
            println("Smaller")
        } else {
            println("You got it!")
            bingo = true
            break
        }

    }
    if (!bingo) {
        println("Failed, the secret is ${secret}")
    }
//    while (num != secret) {
//
//    }


}



