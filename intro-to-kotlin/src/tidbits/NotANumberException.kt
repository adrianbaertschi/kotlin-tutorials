package tidbits

class NotANumberException(message: String) : Throwable(message) {
}

fun check(obj: Any) {
    when (obj) {
        !is Int, Long, Float, Double -> throw NotANumberException("Not a number")
    }
}

fun main() {

    // there are no checked exceptions

    try {
        check("2")
    } catch (e: NotANumberException) {
        println(e.message)
    }


}