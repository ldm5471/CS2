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
    private final Player p1;
    private final Player p2;
    private int round;

    /**
     * Initialize the game.
     *
     * @param cardsPerPlayer the number of cards for a single player
     */
    public War(int cardsPerPlayer) {
        Pile inital = new Pile("Inital");
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                inital.addCard(new Card(rank, suit));
            }
        }
        inital.shuffle();
        System.out.println(inital);
        p1 = new Player(1);
        p2 = new Player(2);
        round = 1;
        for (int i = 0; i < cardsPerPlayer; i++){
            for (int j = 0; j < 2; j ++){
                if (j == 0){
                    p1.addCard(inital.drawCard(false));
                }else{
                    p2.addCard(inital.drawCard(false));
                }
            }

        }
    }
    private void playRound(Pile trick){
        round++;
        System.out.println(p1);
        System.out.println(p2);
        Card p1_card = p1.drawCard();
        Card p2_card = p2.drawCard();
        System.out.println("P1 card: " + p1_card);
        System.out.println("P2 card: " + p2_card);
        trick.addCard(p1_card);
        trick.addCard(p2_card);
        if (p1_card.beats(p2_card)){
            System.out.println("P1 wins round gets " + trick);
            p1.addCards(trick);
            trick.clear();
        }else if (p2_card.beats(p1_card)){
            System.out.println("P2 wins round gets " + trick);
            p2.addCards(trick);
            trick.clear();
        }else if (p1_card.equals(p2_card)){
            System.out.println("WAR!");
            playRound(trick);
        }


    }

    /** Play the full game. */
    public void playGame() {
        Pile trick = new Pile("Trick");
        while (p1.isWinner() == false && p2.isWinner() == false) {
            if (p2.hasCard() == false) {
                p1.setWinner();
                playGame();
            } else if (p1.hasCard() == false) {
                p2.setWinner();
                playGame();
            } else {
                System.out.println("ROUND " + String.valueOf(round));
                playRound(trick);
            }
        }
        if (p1.isWinner()) {
            System.out.println("P1 WINS!");
        } else if (p2.isWinner()) {
            System.out.println("P2 WINS!");
        }

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
