package com.hank.bmi

import android.webkit.PermissionRequest
import androidx.compose.ui.Modifier

class Hello {


}

fun main() {
    val p = Person("Jack", 65.5f, 1.7f)
    println(p.bmi())
    val hank = Person("Hank", 70f, 1.75f)
    println("${p.name}  ${p.bmi()}")
    println("${hank.name}  ${hank.bmi()}")
    p.hello()

    //BMI
    val w = 65.5f
    val h = 1.7f
    val bmi = w / (h * h)
    println("BMI:${bmi}")

    /*
    println("Hello Kotlin!")
    val age = 20
    val population: Long = 9999L
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
    */
}

