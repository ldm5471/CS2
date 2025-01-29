package war;

/**
 * The main program for the card game, War.  It is run on the command line as:<br>
 * <br>
 * java War cards-per-player seed<br>
 * <br>
 *
 * @author RIT CS
 * @author Luke Maeurer
 */

public class War {
    /** The maximum number of cards a single player can have */
    public final static int MAX_CARDS_PER_PLAYER = 26;

    /**
     * Initialize the game.
     *
     * @param cardsPerPlayer the number of cards for a single player
     */
    public War(int cardsPerPlayer) {
        Pile inital = new Pile("inital");
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                inital.addCard(new Card(rank, suit));
            }
        }
        inital.shuffle();
        System.out.println(inital);
        Player p1 = new Player(1);
        Player p2 = new Player(2);
        for (int i = 0; i < cardsPerPlayer; i++){
            for (int j = 0; i < 2; i ++){
                if (j == 0){
                    p1.addCard(inital.drawCard(false));
                }else{
                    p2.addCard(inital.drawCard(false));
                }
            }

        }
    }
    private void playRound(){

    }

    /** Play the full game. */
    public void playGame() {
        System.out.println("War");
    }

    /**
     * The main method get the command line arguments, then constructs
     * and plays the game.  The Pile's random number generator and seed
     * need should get set here using Pile.setSeed(seed).
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java War cards-per-player seed");
        } else {
            int cardsPerPlayer = Integer.parseInt(args[0]);
            // must be between 1 and 26 cards per player
            if (cardsPerPlayer <= 0 || cardsPerPlayer > MAX_CARDS_PER_PLAYER) {
                System.out.println("cards-per-player must be between 1 and " + MAX_CARDS_PER_PLAYER);
            } else {
                // set the rng seed
                Pile.setSeed(Integer.parseInt(args[1]));
                War war = new War(cardsPerPlayer);
                war.playGame();
            }
        }
    }
}
