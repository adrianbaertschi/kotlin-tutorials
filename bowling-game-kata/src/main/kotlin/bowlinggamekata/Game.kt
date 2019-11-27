package bowlinggamekata

fun main() {
    println("Hello, World")
}

const val OPEN = -1
const val BONUS = -2
val NEW_FRAME = Frame(OPEN, OPEN)

data class Frame(var firstThrow: Int, var secondThrow: Int, var bonusPoints: Int = 0) {
    fun strike() = firstThrow == 10
    fun spare() = firstThrow + secondThrow == 10 && bonusPoints == BONUS
    fun total() = firstThrow + secondThrow + bonusPoints
}

class Game {
    private val frames = mutableMapOf<Int, Frame>()

    fun roll(pins: Int) {
        var round = frames.values.indexOfFirst { e -> e.firstThrow == -1 || e.secondThrow == -1 }
        if (round == -1) {
            round = frames.size
        }

        // add bonus points
        addBonusPoints(pins, frames[round - 1])
        addBonusPoints(pins, frames[round - 2])

        if (round > 9) {
            return
        }

        val frame = frames.getOrElse(round) { NEW_FRAME }
        if (frame.firstThrow == OPEN) {
            val strike = pins == 10
            frames[round] = if (strike) Frame(pins, BONUS, BONUS) else Frame(pins, OPEN)
        } else if (frame.secondThrow == OPEN) {
            frames[round]?.secondThrow = pins
            val spare = frame.firstThrow + pins == 10
            if (spare) {
                frames[round]?.bonusPoints = BONUS
            }
        }
    }

    private fun addBonusPoints(pins: Int, frame: Frame?) {
        frame?.apply {
            if (strike()) {
                if (secondThrow == BONUS) {
                    secondThrow = pins
                } else if (bonusPoints == BONUS) {
                    bonusPoints = pins
                }
            } else if (spare()) {
                bonusPoints = pins
            }
        }
    }

    fun score(): Int {
        val sum = frames.values
            .map(Frame::total)
            .sum()

        frames.forEach { (round, frame) -> println("$round: $frame") }
        println("Sum: $sum")

        return sum
    }

}

