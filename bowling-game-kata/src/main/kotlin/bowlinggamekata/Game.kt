package bowlinggamekata

fun main(args: Array<String>) {
    println("Hello, World")
}

class Game {

    private var score = 0

    fun score(): Int {
        return score
    }

    fun roll(pins: Int) {
        score += pins
    }
}

