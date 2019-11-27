package stdlib

fun main() {
    println("Start")
    val elements = 1..1000000000
    val output = elements.filter { it < 30 }.map { Pair("Y", it) }
    output.forEach { println(it) }

    println("Start Lazy")
    val lazyOutput = elements.asSequence().filter { it < 30 }.map { Pair("Y", it) }
    lazyOutput.forEach { println(it) }

    println("Start lazier")
    val lazier = elements.asSequence().take(30)
    lazier.forEach { println(it) }

    val nums = generateSequence(1) { x -> x * 2 }
    println(nums.take(30).sum())

    val lazyInit: Int by lazy {
        println("init now")
        10
    }
    println("bla")
    println(lazyInit)

}