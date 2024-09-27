package com.hank.bmi

fun main() {
    print("Please enter a number(1-10): ")
    val input = readLine()
    val num: Int = input?.toIntOrNull() ?: 0

    println("The number you entered: ${num} ${input?.length}")


}



