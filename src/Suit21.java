import java.util.*;

public class Suit21 {

    private final ArrayList<Player> players;
    private Deck deck;
    private int numPlayers;
    private int numGames;
    private boolean gameEnded;

    public Suit21() {
        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.numGames = 0;
        this.gameEnded = false;
    }

    public void gameRounds() {
        Scanner keyboard = new Scanner(System.in);
        List<Player> playersWhoScored21 = new ArrayList<>();

        // Iterate through game rounds
        for (int round = 1; round <= numGames; round++) {
            System.out.println("\n -------- Round " + round + " --------");

            // Skipping players who have scored 21
            for (Player player : players) {
                if (playersWhoScored21.contains(player)) {
                    continue;
                }

                System.out.println(player.getPlayerName() + "'s turn. \n");
                System.out.println("Your hand:");
                int index = 1;
                for (Card card : player.getHand().getCards()) {
                    System.out.println(index++ + ". " + card);
                }

                // Printing suit values in players' hands
                System.out.println("\nSuit values:");
                player.getHand().printSuitValues();

                if (player.isComputer()) {
                    if (((ComputerPlayer) player).decidingToSwap()) {
                        int cardIndex = new Random().nextInt(player.getHand().getCards().size());
                        Card oldCard = player.getHand().getCards().get(cardIndex);
                        Card newCard = deck.deal();
                        player.getHand().getCards().set(cardIndex, newCard);
                        System.out.println(oldCard + " was replaced with " + newCard);
                    } else {
                        System.out.println(player.getPlayerName() + " decided not to swap cards");
                    }
                } else {


                    // Asking player if they want to swap a card
                    System.out.print("\nDo you want to swap a card? (yes/no): ");
                    String choice = keyboard.nextLine().trim().toLowerCase();

                    // Asking player to choose the card they want to swap
                    if (choice.equals("yes") || choice.equals("y")) {
                        System.out.print("What card do you want to swap? (1-5) ");
                        int cardIndex = keyboard.nextInt() - 1;
                        keyboard.nextLine();

                        if (cardIndex >= 0 && cardIndex < player.getHand().getCards().size()) {
                            Card oldCard = player.getHand().getCards().get(cardIndex);
                            Card newCard = deck.deal();
                            player.getHand().getCards().set(cardIndex, newCard);
                            System.out.println(oldCard + " was replaced with " + newCard);
                        } else {
                            System.out.println("Invalid choice. Turn skipped");
                        }
                    } else {
                        System.out.println("Turn skipped.");
                    }
                }
                System.out.println("Turn over.\n");

                // Check if player has scored 21 and add to playersWhoScored21 list if true
                if (player.getHand().getSuitValues("Hearts") == 21 ||
                        player.getHand().getSuitValues("Diamonds") == 21 ||
                        player.getHand().getSuitValues("Clubs") == 21 ||
                        player.getHand().getSuitValues("Spades") == 21) {
                    System.out.println(player.getPlayerName() + " has scored 21 from a single suit!");
                    if (!playersWhoScored21.contains(player)) {
                        player.setScore(player.getScore() + 1);
                        playersWhoScored21.add(player);
                    }
                }
            }
        }

        System.out.println("\n-------- Final Scores --------");
        descendingScores();
             for (Player player : players) {
            System.out.println(player.getPlayerName() + ": " + player.getScore());
        }
    }

    // Sorting scores into descending order
    public void descendingScores() {
        Collections.sort(players, (player1, player2) -> Integer.compare(player2.getScore(), player1.getScore()));
            }

    // Asking how many rounds of games the player would like to play
    public void numOfGames() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("How many games would you like to play? ");
        numGames = keyboard.nextInt();

    }

   public void numOfPlayers() {
       Scanner keyboard = new Scanner(System.in);
            // Asking how many players are playing
            do {
                System.out.print("How many players? (2-6) ");
                numPlayers = keyboard.nextInt();
                keyboard.nextLine();
            } while (numPlayers < 2 || numPlayers > 6);

            // Asking for players names
       for (int i = 0; i < numPlayers; i++) {
           System.out.print("Enter player " + (i + 1) + " name: " );
           String playerName = keyboard.nextLine();


               if (playerName.equalsIgnoreCase("Computer")) {
                   players.add(new ComputerPlayer("Computer"));
               } else {
                   players.add(new Player(playerName));
              }
      }
   }

    // Dealing players cards
    public void dealCards() {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.getHand().addCard(deck.deal());
            }
        }
   }

   public List<Player> getPlayers() {
        return players;
   }

    public Deck getDeck() {
        return deck;
    }

    public static void main(String[] args) {
        Suit21 game = new Suit21();
        game.numOfGames();
        game.numOfPlayers();
        game.dealCards();
        game.gameRounds();


    }


}