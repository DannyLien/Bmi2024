package com.hank.bmi.student

open class Student(
    val id: String, val name: String,
    var english: Int = 0, var math: Int = 0
) {
    //    constructor(id: String, name: String) : this(id, name, 0, 0)
    companion object {
        var pass = 60
    }

    open fun print() {
        val mark = if (average() < pass) "*" else " "
        println("$id\t$name\t$english\t$math\t${average()}$mark\t${grading()}")
    }

    fun average() = (english + math) / 2

    fun grading() = when (average() / 10) {
        9, 10 -> "A"
        8 -> "B"
        7 -> "C"
        6 -> "D"
        else -> "F"
    }

}


fun main() {
    Student.pass = 50
    val students = listOf<Student>(
        Student("001", "Jack", 40, 50),
        Student("002", "Hank", 66, 87),
        Student("003", "Jane")
    )
    for (i in (0..2)) {
        students.get(i).print()
    }
    for (i in students) {
        i.print()
    }
    students.forEach {
        it.print()
    }


//    stu.print()
//    stu2.print()
//    stu3.print()

}




