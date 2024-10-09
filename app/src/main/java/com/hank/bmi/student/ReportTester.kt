package com.hank.bmi.student

fun main() {
    val reports = listOf<Report>(
        FinanceReport(),
        HealthReport(),
        object : Report {
            override fun load() {
                println("Ex Report")
            }

            override fun print(title: String) {
                println("Printing")
            }
        }
    )
    for (report in reports) {
        report.load()
        report.print("Test")

    }

}






