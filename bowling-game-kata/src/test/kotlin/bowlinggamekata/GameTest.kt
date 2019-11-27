package bowlinggamekata

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class GameTest {


    lateinit var game: Game

    @Before
    fun setup() {
        game = Game()
    }

    @Test
    fun create_new_game_score_is_zero() {
        assertEquals(0, game.score())
    }

    @Test
    fun allRolls_0PinEach() {
        repeat(20) { game.roll(0) }
        assertEquals(0, game.score()) // 0 = 20 * (0 + 0)
    }

    @Test
    fun allRolls_1PinEach() {
        repeat(20) { game.roll(1) }
        assertEquals(20, game.score()) // 20 = 10 * (1 + 1)
    }

    @Test
    fun allRolls_2PinEach() {
        repeat(20) { game.roll(2) }
        assertEquals(40, game.score()) // 40 = 10 * (2 + 2)
    }

    @Test
    fun allRolls_allStrikes() {
        repeat(10) { strike() }
        strike() // bonus for last frame
        strike() //
        assertEquals(300, game.score()) // 300 = 10 * (10 + 10 + 10)
    }

    private fun strike() {
        game.roll(10)
    }

    @Test
    fun allRolls_allSpares() {
        repeat(20) { game.roll(5) }
        game.roll(5) // bonus for the last spare
        assertEquals(150, game.score()) // 150 = 10 * (5 + 5 + 5)
    }

    @Test
    fun mixedRolls_realGame() {
        strike() // frame 1
        frame(4, 4)
        frame(7, 1)
        frame(2, 7)
        spare(3) // frame 5
        strike()
        strike()
        strike()
        frame(1, 0)
        strike() // frame 10, finish
        frame(9, 1)
        assertEquals(
            146,
            game.score()
        ) // (10 + 4 + 4) + (4 + 4) + (7 + 1) + (2 + 7) + (3 + 7 + 10) + (10 + 10 + 10) + (10 + 10 + 1) + (10 + 1 + 0) + (1 + 0) + (10 + 9 + 1)
    }

    @Test
    fun mixedRolls_mentiGame() {
        frame(0, 1)
        strike()
        spare(9)
        frame(3, 3)
        repeat(6) { frame(0, 0) }
        assertEquals(40, game.score()) // (1) + (10 + 9 + 1) + (3 + 3) + 6*(0 + 0)
    }

    private fun spare(first: Int) {
        frame(first, 10 - first)
    }

    private fun frame(first: Int, second: Int) {
        game.roll(first)
        game.roll(second)
    }

}
