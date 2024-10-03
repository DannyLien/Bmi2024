package com.hank.bmi.vending

import java.net.URL

fun main() {
    //https://api.jsonserve.com/AXh1oX  Tom
    //https://api.jsonserve.com/fYyexG  Danny
    //JSON Example

//    val text = URL("https://api.jsonserve.com/fYyexG").readText()

    val input = URL("https://api.jsonserve.com/fYyexG").openStream()
    val reader = input.bufferedReader()
    var line = reader.readLine()
    while (line != null) {
        println(line)
        line = reader.readLine()
    }


}









