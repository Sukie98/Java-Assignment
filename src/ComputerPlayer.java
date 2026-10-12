public class ComputerPlayer extends Player{

    public ComputerPlayer(String playerName) {
        super(playerName, true);
    }

    public boolean decidingToSwap() {
        for (String suit : new String[] {"Clubs", "Diamonds", "Hearts", "Spades"}) {
            if (this.getHand().getSuitValues(suit) < 15) {
                return true;
            }
        }
        return false;
    }
}