public class Card {

    private int rank;
    private int suit;

    private static String[] ranks = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
    private static String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};

    public Card(int rank, int suit ) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRankName() {
        return Card.ranks[this.rank];
    }

    public String getSuit() {
        return Card.suits[this.suit];
    }

    public int getRank() {
        if (rank >= 0 && rank <= 8) {
            return rank + 2;
        }
        else if (rank >= 9 && rank <= 11) {
            return 10;
        } else {
            return 11;
        }
    }

    public String toString() {
        return getRankName() + " of " + getSuit();
    }
}

