package functions

fun main() {
    hello()
}

// Unit: Void object, hello returns Unit
fun hello() {
    println("Hello")
}

// never exists
fun hello2(): Nothing {
    println("asdf")
    throw Exception("asdf")
}

fun four() = 4

fun sum(x: Int, y: Int) = x + y

fun print(vararg s: String) {
    val ss = s
    printAll(*s) // spread
}

fun printAll(vararg strings: String) {
    for (string in strings) {
        println(string)
    }
}