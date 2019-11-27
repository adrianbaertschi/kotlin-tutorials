package bowlinggamekata

fun main() {
    println("Hello, World")
}

const val OPEN = -1
const val BONUS = -2

data class Frame(var firstThrow: Int, var secondThrow: Int, var bonusPoints: Int = 0)

class Game {
    private val frames = mutableMapOf<Int, Frame>()


    fun score(): Int {
        val sum = frames.values.map { frame -> frame.firstThrow + frame.secondThrow + frame.bonusPoints }
            .sum()

        frames.forEach { (round, frame) -> println("$round: $frame") }
        println("Sum: $sum")

        return sum
    }

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

        // current throw
        val currentFrame = frames.getOrElse(round) { Frame(OPEN, OPEN) }
        if (currentFrame.firstThrow == OPEN) {
            if (pins == 10) { // strike
                frames[round] = Frame(pins, BONUS, BONUS)
            } else {
                frames[round] = Frame(pins, OPEN)
            }
        } else if (currentFrame.secondThrow == OPEN) {
            if (currentFrame.firstThrow + pins == 10) { // spare
                frames[round]?.bonusPoints = BONUS
            }
            frames[round]?.secondThrow = pins
        }
    }

    private fun addBonusPoints(pins: Int, frame: Frame?) {
        frame?.apply {
            if (firstThrow == 10) {
                if (secondThrow == BONUS) {
                    secondThrow = pins
                } else if (bonusPoints == BONUS) {
                    bonusPoints = pins
                }
            } else if (firstThrow + secondThrow == 10) {
                if (bonusPoints == BONUS) {
                    bonusPoints = pins
                }
            }
        }
    }
}

