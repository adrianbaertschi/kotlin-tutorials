package functional

fun String.hello() {
    println("Hi")
}

fun String.toTitleCase(): String {
    // this is the objects of which the function is invoked
    return this.split(" ").joinToString(" ") { it.capitalize() }
}

fun String.isNotEmpty(): Boolean {
    println("My custom isNotEmpty")
    return this.length != 0
}

fun main() {
    "abc".hello()
    println("This is a sample".toTitleCase())

    "bla".isNotEmpty()
}
