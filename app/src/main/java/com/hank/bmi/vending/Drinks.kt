package com.hank.bmi.vending


fun Drink.off20(): Drink {
    return this.copy(price = (this.price * 0.8).toInt())
}

fun main() {
    val s = "abcef"
    println(s.validate())
    val tea = Drink("Black tea", 0, 50)
    val discountTea = tea.off20()
    println(tea)
    println(discountTea)
    val tea2 = tea.copy(suger = 5)
    println(tea2)

    val drinks = mutableMapOf<Int, String>(
        1 to "Coke",
        2 to "7-UP",
        3 to "Wulllng",
        4 to "Orange"
    )
    println(drinks)
    println(drinks.get(3))
    drinks.set(5, "Water")
    println(drinks)

}

fun String.validate(): Boolean {
    return this.length >= 6
}








