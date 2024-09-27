package com.hank.bmi

fun main() {
    var name: String? = "Hank"
    println(name?.length)
    println(name ?: 0)

    var counter = 0
    counter = counter + 1
    counter++
    counter = counter - 1
    println(counter)
    println(10 / 3.0)
    //Boolean
    var b = false
    var a = false
    println(a && b)
    println(a || b)
    //
    val num = -8
    println(num <= 5 && num >= -3)
    //
    println(num > 5 || num < -3)

}