import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    @Test
    void fullDeckTest() {
        Deck deck = new Deck();
        int expectedCardCount = 52;
        int actualCardCount = deck.getDeck().size();
        assertEquals(expectedCardCount, actualCardCount);
    }

    @Test
    void drawTest() {
        Deck deck = new Deck();
        int initialSize = deck.getDeck().size();
        Card topCard = deck.peek();
        Card deckDraw = deck.pop();
        assertEquals(topCard,deckDraw);
    }
}