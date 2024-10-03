package com.hank.bmi.student

class HealthReport : Report {
    override fun load() {
        println("Loading Health report...")
    }

    override fun print(title: String) {
        println("Printing Health report...")
    }
}