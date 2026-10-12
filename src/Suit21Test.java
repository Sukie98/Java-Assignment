import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class Suit21Test {

    @Test
    void gameInitializationTest() {
        Suit21 game = new Suit21();
        Deck deck = game.getDeck();
        List<Player> players = game.getPlayers();

        // Check that the game has the correct number of players
        assertEquals(4, players.size());

        for (Player player : players) {
            assertNotNull(player.getHand());
        }

        // Check that the deck is initialized
        assertNotNull(deck);
        assertEquals(52, deck.getCards().size());
    }
}