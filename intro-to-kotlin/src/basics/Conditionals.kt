package basics

fun main() {
    var s = "adf"

    val res = if (s != "") {
        100
    } else {
        30
    }
    println(res)


    when (res) {
        10 -> println("Int")
        else -> "Else"
    }
}