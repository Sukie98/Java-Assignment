import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {
@Test
    public void decidingToSwap() {
    ComputerPlayer computer = new ComputerPlayer("Computer");
    Hand hand = computer.getHand();

    hand.addCard(new Card(1,0));
    hand.addCard(new Card(1,1));
    hand.addCard(new Card(1,2));
    hand.addCard(new Card(0,0));
    hand.addCard(new Card(0,1));

    assertTrue(computer.decidingToSwap(), "Computer should swap with weak cards");
}
    @Test
    void computerPlayerInitialization() {
        ComputerPlayer computer = new ComputerPlayer("Computer");

        assertEquals("Computer", computer.getPlayerName(), "Computer should be entered as name.");
        assertTrue(computer.isComputer(), "ComputerPlayer should be marked as a computer.");
    }


}