package com.hank.bmi

fun main() {
    val deck = mutableListOf<Int>()
    for (i in (0 until 52)) {
        deck.add(i)
        if (i % 13 == 0 && i != 0) println()
        val a = i / 13
        var type = when (a) {
            0 -> "♣"    //"C"
            1 -> "♢"       //"D"
            2 -> "♡"       //"H"
            else -> "♠"    //"S"
        }

//        var type = if (a == 0) {
//            "C"
//        } else if (a == 1) {
//            "D"
//        } else if (a == 2) {
//            "H"
//        }else "S"

        print("${(i % 13) + 1}${type} ")
    }

}














