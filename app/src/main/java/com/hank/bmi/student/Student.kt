package com.hank.bmi.student

class Student(
    val id: String, val name: String,
    var english: Int, val math: Int
) {
    constructor(id: String, name: String) : this(id, name, 0, 0)

    fun print() {
        println("$id\t$name\t$english\t$math")
    }

}


fun main() {
    val stu = Student("001", "Jack", 70, 80)
    val stu2 = Student("002", "Hank", 66, 87)
    val stu3 = Student("003", "Jane")
    stu.print()
    stu2.print()
    stu3.print()

}




