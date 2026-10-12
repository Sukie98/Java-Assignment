public class Player {
    private String playerName;
    private boolean isComputer;
    private int score;
    private Hand hand;

    // Constructor for human players
    public Player(String playerName) {
        this.playerName = playerName;
        this.isComputer = false;
        this.score = 0;
        this.hand = new Hand();
    }

    // Constructor for computer players
    public Player(String playerName, boolean isComputer) {
        this.playerName = playerName;
        this.isComputer = isComputer;
        this.score = 0;
        this.hand = new Hand();
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Hand getHand() {
        return this.hand;
    }

    public String toString() {
        return playerName + "'s hand " + hand;
    }

    public boolean isComputer() {
        return this.isComputer;
    }
}
