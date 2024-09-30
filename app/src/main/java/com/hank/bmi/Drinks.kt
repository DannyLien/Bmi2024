package com.hank.bmi

fun main() {
    val drinks = mutableMapOf<Int, String>(
        1 to "Coke",
        2 to "7-UP",
        3 to "Wulllng",
        4 to "Orange"
    )
    println(drinks)
    println(drinks.get(3))
    drinks.set(5, "Water")
    println(drinks)

}








