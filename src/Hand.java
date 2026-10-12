import java.util.ArrayList;
import java.util.List;

public class Hand {
      private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }


        // Getting values of each suit in players hand
    public int getSuitValues(String suit) {
        int total = 0;
        for (Card card : cards) {
            if (card.getSuit().equals(suit)) {
                total += card.getRank();
            }
        }
        return total;
    }

    public void printSuitValues() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        for (String suit : suits) {
            int value = getSuitValues(suit);
            System.out.println(suit + ": " + value);
        }
    }

    public String toString() {
        String resultStr = "\n";
        for(Card card : cards) {
            resultStr += card +"\n";
        }
        return resultStr;
    }
}

