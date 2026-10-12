import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    @Test
    void addingCards() {
        Hand hand = new Hand();
        Card card = new Card(3,2);

        hand.addCard(card);

        assertTrue(hand.getCards().contains(card), "Card should be in hand");
        assertEquals(1, hand.getCards().size(), "Hand should contain at least one card");
    }

    @Test
    void removingCards() {
        Hand hand = new Hand();
        Card card = new Card(3,2);

        hand.addCard(card);
        hand.removeCard(card);

        assertFalse(hand.getCards().contains(card), "Card should be removed from hand");
        assertEquals(0,hand.getCards().size(),"Hand should empty");
    }
}