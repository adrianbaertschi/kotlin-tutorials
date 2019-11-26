package functional

fun outside() {

    for (i in 1..30) {
        // closure; access to values outside of params
        unary(20) { x ->
            println(i)
            x * i
        }
    }
}

fun main() {
    outside()
}