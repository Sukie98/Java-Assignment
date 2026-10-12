import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void newPlayerTest() {
         Player player = new Player("Jane");

        assertEquals("Jane", player.getPlayerName());
    }

    @Test
    void scoreTest() {
        Player player = new Player("Jane");

        player.setScore(10);

        assertEquals(10, player.getScore());

        player.setScore(20);

        assertEquals(20, player.getScore());
    }

}