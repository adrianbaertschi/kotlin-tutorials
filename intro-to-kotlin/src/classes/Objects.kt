package classes

fun main() {
    println(Global.pi)

    val local = object {
        val bla = 4;
    }
    println(local.bla)
}

// Singleton
object Global {
    val pi = 3;
}