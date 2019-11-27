package bowlinggamekata

fun main(args: Array<String>) {
    println("Hello, World")
}

class Game {

    private val frames = mutableMapOf<Int, Pair<Int, Int>>()


    fun score(): Int {
        return frames.values.map { p -> p.first + p.second }.sum()
    }

    fun roll(pins: Int) {
        var round = frames.values.indexOfFirst { e -> e.first == -1 || e.second == -1 }
        if (round == -1) {
            round = frames.size;
        }
        val frame = frames.getOrElse(round) { Pair(-1, -1) };


        if (frame.first == -1) {
            frames[round] = Pair(pins, -1)
            return
        }
        if (frame.second == -1) {
            val frameCopy = frame.copy(second = pins)
            frames[round] = frameCopy
        }
    }
}

