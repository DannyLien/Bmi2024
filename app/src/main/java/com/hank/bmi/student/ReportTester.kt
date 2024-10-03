package com.hank.bmi.student

fun main() {
    val reports = listOf<Report>(
        FinanceReport(),
        HealthReport()
    )
    for (report in reports) {
        report.load()
        report.print("Test")
    }

}






