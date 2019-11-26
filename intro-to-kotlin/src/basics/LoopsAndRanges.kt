package basics

fun main() {
    for (a in 1..100) {
        println(a)
    }

    val nums = 1..100
    for (num in nums) {
        println(num)
    }

    for (a in 100 downTo 1) {
        println(a)
    }

    for (a in 100..1) {
        println(a)
    }

    for (a in 100 downTo 1 step 5) {
        println(a)
    }

    loop@ for (a in 1..100) {
        for (b in 1..100) {
            if (a % b == 0) {
                break@loop
            }
        }
    }
}