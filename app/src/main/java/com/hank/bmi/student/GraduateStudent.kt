package com.hank.bmi.student

class GraduateStudent(id: String, name: String, english: Int, math: Int, val thesis:Int) :
    Student(id, name, english, math) {

        override fun print(){
            val mark = if (average() < pass) "*" else " "
            println("$id\t$name\t$english\t$math\t${average()}$mark\t${grading()}\t$thesis")
        }

}


fun main() {
    val gstu = GraduateStudent("008","Emma",90,90,85)
    gstu.print()

}


