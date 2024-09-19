package com.hank.bmi

import androidx.compose.ui.Modifier

class Hello {


}

fun main() {

    val p = Person()
    p.hello()

    println("Hello Kotlin!")
    val age = 20
    val population:Long = 9999L
    println(population)
    println(age.inc())
    println(age)
    var name = "Hank"
    println(name.get(1))
    name = "Jack"
    println(name)
    //Float(32), Double(64)
    val weight: Float = 65.5f
    println(weight)
    //true, false
    val isadult = false
    println(isadult)
    //Char
    val c = 'A'
    println(c)

}

