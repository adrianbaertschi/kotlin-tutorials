package stdlib

fun main() {
    val strings = listOf("First", "Second") // immutable
    println(strings.javaClass) // java.util.Arrays$ArrayList
    println(emptyList<String>().javaClass) // kotlin.collections.EmptyList

    val mut = mutableListOf("First", "Second")
    println(mut.javaClass) // java.util.ArrayList
    mut.add("Third")

    val hashMap = hashMapOf(Pair("A", 1), Pair("B", 2))
    val i = hashMap["A"]
    val booleanArrayOf = booleanArrayOf(true, false, true)


}