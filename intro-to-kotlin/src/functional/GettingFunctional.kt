package functional

// higher order function
fun operation(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
}

fun sum(x: Int, y: Int) = x + y

fun unary(x: Int, op: (Int) -> Int): Int {
    return op(x)
}

fun transaction(db: Database, code: () -> Unit) {
    try {
        code()
    } finally {
        db.commit()
    }
}

class Database {
    fun commit() {
        println("Commit")
    }
}

fun main() {
    println(operation(1, 2, ::sum))

    // is the same
    println(operation(1, 2, { x, y -> x + y })) // warning
    println(operation(1, 2) { x, y -> x + y })

    // can use it, is the same
    println(unary(2) { x -> x * x })
    println(unary(2) { it * it })


    // feels like a DSL
    val db = Database()
    transaction(db) {
        println("Do db stuff")
        // commit gets called after
    }
}