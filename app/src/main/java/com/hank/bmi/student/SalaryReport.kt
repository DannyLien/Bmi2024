package com.hank.bmi.student

class SalaryReport : MyReport() {
    override fun load() {
        println("Loading data")
        printBB()
        init()
    }


}