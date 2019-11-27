package bowlinggamekata

fun main(args: Array<String>) {
    println("Hello, World")
}

class Game {

    private val frames = mutableMapOf<Int, Triple<Int, Int, Int>>()


    fun score(): Int {
        println(frames)
        return frames.values.map { p -> filterSpecial(p.first) + filterSpecial(p.second) + filterSpecial(p.third) }
            .sum()
    }

    private fun filterSpecial(points: Int): Int {
        if (points >= 0) {
            return points;
        }
        return 0
    }

    fun roll(pins: Int) {
        var round = frames.values.indexOfFirst { e -> e.first == -1 || e.second == -1 }
        if (round == -1) {
            round = frames.size;
        }

        // add bonus points to prev
        val prevFrame = frames[round - 1]
        if (prevFrame != null) {
            if (prevFrame.first == 10) {
                if (prevFrame.second == -2) {
                    frames[round - 1] = prevFrame.copy(second = pins)
                }
            }
        }

        // add bonus points to prev-1
        val prePrevFrame = frames[round - 2]
        if (prePrevFrame != null) {
            if (prePrevFrame.first == 10) {
                if (prePrevFrame.third == -2) {
                    frames[round - 2] = prePrevFrame.copy(third = pins)
                }
            }
        }

        if (round > 9) {
            frames[9] = frames[9]!!.copy(third = pins)
            return
        }

        // current throw
        val currentFrame = frames.getOrElse(round) { Triple(-1, -1, 0) }
        if (currentFrame.first == -1) {
            if (pins == 10) {
                frames[round] = Triple(pins, -2, -2)
            } else {
                frames[round] = Triple(pins, -1, 0)
            }
            return
        }
        if (currentFrame.second == -1) {
            val frameCopy = currentFrame.copy(second = pins)
            frames[round] = frameCopy
        }
    }

}

