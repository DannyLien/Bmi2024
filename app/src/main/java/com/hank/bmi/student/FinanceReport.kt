package com.hank.bmi.student

class FinanceReport : Report {
    override fun load() {
        println("Loading Finance report...")
    }

    override fun print(title: String) {
        println("Printing Finance report...")
    }
}