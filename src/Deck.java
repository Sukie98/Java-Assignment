import java.util.Collection;
import java.util.Stack;
import java.util.Collections;

public class Deck {

    private Stack<Card> deck;

    public Deck() {
        this.deck = new Stack<>();
        for (int i = 0; i < 52; i++) {
            this.deck.push(new Card(i % 13, i/ 13)) ;
        }

        Collections.shuffle(this.deck);
    }

    public Card deal() {
        if (!deck.isEmpty()) {
            return deck.pop();
        } else {
            return null;
        }
    }
    public Stack<Card> getDeck() {
        return deck;
    }

    public Card pop() {
        return deck.pop();
    }

    public Card peek() {
        return deck.peek();
    }

    public Collection<Object> getCards() {
        return getCards();
    }
}