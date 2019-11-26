package tidbits

import classes.Customer2

fun getPair(): Pair<String, Long> {
    return Pair("Bla", 2999);
}

fun getTriple(): Triple<String, String, Long> {
    return Triple("Bla", "Ha", 2000)
}

fun main() {
    println(getPair())
    println(getTriple())

    // Deconstruct
    val (capital, pupulation) = getPair();
    val (capital2, more, pupulation2) = getTriple()

    val (id, name) = Customer2(1, "Adrian")

    val list = listOf(Pair("A", 1), Pair("B", 2), Pair("C", 3))
    for ((letter, number) in list) {
        println("$letter $number")
    }

}