package com.hank.bmi

fun main() {
    val scret = 7
    print("Please enter a number(1-10): ")
    val input = readLine()
    val num: Int = input?.toIntOrNull() ?: 0
    println("The number you entered: ${num} ")

    if (num < scret) {
        println("Bigger")
    } else if (num > scret) {
        println("Smaller")
    } else {
        println("You got it!")
    }

}



