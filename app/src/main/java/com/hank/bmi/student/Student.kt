package com.hank.bmi.student

class Student(
    val id: String, val name: String,
    var english: Int = 0, var math: Int = 0
) {
//    constructor(id: String, name: String) : this(id, name, 0, 0)

    fun print() {
        println("$id\t$name\t$english\t$math\t${average()}\t${grading()}")
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
    val students = listOf<Student>(
        Student("001", "Jack", 95, 99),
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




