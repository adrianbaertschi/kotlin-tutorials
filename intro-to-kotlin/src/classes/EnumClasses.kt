package classes

fun main() {
    val prio = Prio.MAJOR
    println(prio.ordinal)

    for (value in Prio.values()) {
        println(value)
    }
}

enum class Prio(i: Int) {
    MINOR(10) {
        override fun text(): String {
            return "askdfj"
        }
    },
    NORMAL(100) {
        override fun text(): String {
            return "asdf"
        }
    },
    MAJOR(1000) {
        override fun text(): String {
            return "asdfsadf"
        }
    }; // required ;

    abstract fun text(): String
}