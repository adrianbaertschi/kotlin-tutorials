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

}
