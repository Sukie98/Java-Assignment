import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void cardInitializationTest() {
        Card card = new Card(8, 2);
        assertEquals("Hearts", card.getSuit());
        assertEquals(10, card.getRank());

    }

    @Test
    void faceCardRankTest() {
        Card jack = new Card(9, 3);
        assertEquals(10, jack.getRank());

    }

    @Test
    void toStringTest() {
        Card ace = new Card(12, 0);
        assertEquals("Ace of Clubs", ace.toString());

    }

}