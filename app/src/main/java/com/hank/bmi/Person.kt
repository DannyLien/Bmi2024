package com.hank.bmi

class Person (val name:String, val weight:Float, val height:Float){

    fun bmi(): Float = weight / (height * height)

    fun hello() {
        println("Person Hello !!")
    }

}