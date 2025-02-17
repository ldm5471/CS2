import java.util.*;

/**
 * CSCI-142 Computer Science 3 Recitation Presentation
 * 05-JCF1
 * Game
 *
 * The game collector has a bunch of different types of games that they
 * store in various JCF collection classes.
 *
 * $ java GameCollector
 * findGamesSlow...
 *   find Game{name='Settlers of Catan', year=1995, cost=34.99, type=BOARD}
 *     passed!
 *   find Game{name='Fortnite', year=2017, cost=0.0, type=VIDEO} passed!
 *   find Game{name='Magic The Gathering', year=1993, cost=33.55, type=CARD}
 *     passed!
 *   find Game{name='World of Warcraft', year=2004, cost=49.99, type=VIDEO}
 *     passed!
 *   find Game{name='World of Warcraft', year=2005, cost=39.99, type=BOARD}
 *     passed!
 *   find Game{name='Halo 2', year=2004, cost=59.99, type=VIDEO} passed!
 *   find duplicate Game{name='Settlers of Catan', year=1995, cost=19.99,
 *     type=BOARD} passed!
 *   don't find Game{name='Team Fortress 2', year=2007, cost=0.0,
 *     type=VIDEO} passed!
 *   don't find Game{name='Fortnite', year=2001, cost=0.0, type=VIDEO} 
 *     passed!
 *   don't find Game{name='Fortnite', year=2007, cost=0.0, type=CARD}
 *     passed!
 * orderGames...
 *   0 is Game{name='Magic The Gathering', year=1993, cost=33.55, 
 *       type=CARD} passed!
 *   1 is Game{name='Settlers of Catan', year=1995, cost=34.99, type=BOARD}
 *     passed!
 *   2 is Game{name='Halo 2', year=2004, cost=59.99, type=VIDEO} passed!
 *   3 is Game{name='World of Warcraft', year=2004, cost=49.99, type=VIDEO}
 *     passed!
 *   4 is Game{name='World of Warcraft', year=2005, cost=39.99, type=BOARD}
 *     passed!
 *   5 is Game{name='Fortnite', year=2017, cost=0.0, type=VIDEO} passed!
 * orderGamesSpecial...
 *   0 is Game{name='Magic The Gathering', year=1993, cost=33.55, type=CARD}
 *     passed!
 *   1 is Game{name='World of Warcraft', year=2005, cost=39.99, type=BOARD}
 *     passed!
 *   2 is Game{name='Settlers of Catan', year=1995, cost=34.99, type=BOARD}
 *     passed!
 *   3 is Game{name='Halo 2', year=2004, cost=59.99, type=VIDEO} passed!
 *   4 is Game{name='World of Warcraft', year=2004, cost=49.99, type=VIDEO}
 *     passed!
 *   5 is Game{name='Fortnite', year=2017, cost=0.0, type=VIDEO} passed!
 * findGamesFast...
 *   find Game{name='Settlers of Catan', year=1995, cost=34.99, type=BOARD}
 *     passed!
 *   find Game{name='World of Warcraft', year=2005, cost=39.99, type=BOARD}
 *     passed!
 *   find Game{name='Magic The Gathering', year=1993, cost=33.55, type=CARD}
 *     passed!
 *   find Game{name='Halo 2', year=2004, cost=59.99, type=VIDEO} passed!
 *   find Game{name='World of Warcraft', year=2004, cost=49.99, type=VIDEO}
 *     passed!
 *   find Game{name='Fortnite', year=2017, cost=0.0, type=VIDEO} passed!
 *   find duplicate Game{name='Settlers of Catan', year=1995, cost=19.99,
 *     type=BOARD} passed!
 *   don't find Game{name='Team Fortress 2', year=2007, cost=0.0,
 *     type=VIDEO} passed!
 *   don't find Game{name='Fortnite', year=2001, cost=0.0, type=VIDEO}
 *     passed!
 *   don't find Game{name='Fortnite', year=2007, cost=0.0, type=CARD}
 *     passed!
 * timesPlayed...
 *   find key Game{name='Halo 2', year=2004, cost=59.99, type=VIDEO} 
 *     passed!
 *   don't find key Game{name='Halo 2', year=2004, cost=59.99, type=VIDEO}
 *     passed!
 *   Times played least to most:
 *     0 is Game{name='World of Warcraft', year=2005, cost=39.99,
 *       type=BOARD}/5 passed!
 *     1 is Game{name='Settlers of Catan', year=1995, cost=34.99,
 *       type=BOARD}/100 passed!
 *     2 is Game{name='Magic The Gathering', year=1993, cost=33.55,
 *       type=CARD}/600 passed!
 *     3 is Game{name='World of Warcraft', year=2004, cost=49.99,
 *       type=VIDEO}/9000 passed!
 *     4 is Game{name='Halo 2', year=2004, cost=59.99,
 *       type=VIDEO}/15000 passed!
 *     5 is Game{name='Fortnite', year=2017, cost=0.0,
 *       type=VIDEO}/5000005 passed!
 *
 * @author RIT CS
 */
public class GameCollector {
    /** all games are stored in a list */
    private List<Game> gameList;
    /** the board game, Settlers of Catan */
    private Game catanBoard;
    /** the video game, Fortnite */
    private Game fortniteVideo;
    /** the card game, Magic The Gathering */
    private Game magicCard;
    /** the video game, World of Warcraft */
    private Game wowVideo;
    /** the board game, World of Warcraft */
    private Game wowBoard;
    /** the video game, Halo 2 */
    private Game haloVideo;

    /**
     * A test function that exits the program if the expected result does
     * not match the actual result.  Thanks to Prof. St. Jacques.
     *
     * @param testName the test name to display
     * @param expected the expected result
     * @param actual the actual result
     * @param errorMessage the error message if expected != actual
     */
    public static void assertEquals(String testName, Object expected,
                                    Object actual, String errorMessage) {
        if (expected.equals(actual)) {
            System.out.println(testName + " passed!");
        } else {
            String output = testName + " failed, expected " + expected +
                    ", but got " + actual;
            output = errorMessage != null ? output + "; " +
                    errorMessage : output;
            System.out.println(output);
            System.exit(1);
        }
    }

    /**
     * Create the collection of games and store them in a list.
     */
    public GameCollector() {
        this.gameList = new ArrayList<>();

        // add the new games in
        this.gameList.add(new Game("Settlers of Catan", 1995, 34.99,
                Game.Type.BOARD));
        this.gameList.add(new Game("Fortnite", 2017, 0.00,
                Game.Type.VIDEO));
        this.gameList.add(new Game("Magic The Gathering", 1993, 33.55,
                Game.Type.CARD));
        this.gameList.add(new Game("World of Warcraft", 2004, 49.99,
                Game.Type.VIDEO));
        this.gameList.add(new Game("World of Warcraft", 2005, 39.99,
                Game.Type.BOARD));
        this.gameList.add(new Game("Halo 2", 2004, 59.99,
                Game.Type.VIDEO));

        // get references to each of the games
        this.catanBoard = this.gameList.get(0);
        this.fortniteVideo = this.gameList.get(1);
        this.magicCard = this.gameList.get(2);
        this.wowVideo = this.gameList.get(3);
        this.wowBoard = this.gameList.get(4);
        this.haloVideo = this.gameList.get(5);
    }

    /**
     * Test finding games in our collection using the List method 
     * contains().  This exercises the Game method equals().
     */
    public void findGamesSlow() {
        System.out.println("findGamesSlow...");
        for (Game game : this.gameList) {
            assertEquals("\tfind " + game,
                    true,
                    this.gameList.contains(game),
                    "\tcouldn't find " + game.getName());
        }

        // find same game with different cost - this is ok by our definition
        Game goodCatan = new Game("Settlers of Catan", 1995,
                19.99, Game.Type.BOARD);
        assertEquals("\tfind duplicate " + goodCatan,
                true,
                this.gameList.contains(goodCatan),
                "\tcouldn't find " + goodCatan.getName());

        // can't find a game that doesn't exist in the collection
        Game tf2 = new Game("Team Fortress 2", 2007, 0.00,
                Game.Type.VIDEO);
        assertEquals("\tdon't find " + tf2,
                false,
                this.gameList.contains(tf2),
                "\tcouldn't find " + tf2.getName() + "!");

        // be tricky and try to find a wrong copy of Fortnite
        List<Game> badGames = new ArrayList<>();
        badGames.add(new Game("Fortnite", 2001, 0, Game.Type.VIDEO));
        badGames.add(new Game("Fortnite", 2007, 0, Game.Type.CARD));

        for (Game badFortnite : badGames) {
            assertEquals("\tdon't find " + badFortnite,
                    false,
                    this.gameList.contains(badFortnite),
                    "\tcouldn't find " + badFortnite.getName() + "!");
        }
    }

    /**
     * Get the natural order of the games, which is first be increasing
     * year and second alphabetically.  This exercises the Game method
     * compareTo().
     */
    public void orderGames() {
        System.out.println("orderGames...");

        // the expected order of games
        List<Game> expectedOrder = new ArrayList<>(Arrays.asList(
                this.magicCard,
                this.catanBoard,
                this.haloVideo,
                this.wowVideo,
                this.wowBoard,
                this.fortniteVideo
        ));

        // create a tree set out of the list of games
        Set<Game> gameTree = new TreeSet<>(this.gameList);

        // test the order is correct
        int i=0;
        for (Game game : gameTree) {
            assertEquals("\t" + i + " is " + expectedOrder.get(i),
                    true,
                    game.equals(expectedOrder.get(i)),
                    "\twrong order " + expectedOrder.get(i).getName());
            ++i;
        }
    }

    /**
     * Order the games specially.  Here we want to order by the type first
     * (as they are listed in the Game.Type enum (alphabetically) and
     * second by decreasing cost.
     */
    public void orderGamesSpecial() {
        System.out.println("orderGamesSpecial...");

        // the expected order of games
        List<Game> expectedOrder = new ArrayList<>(Arrays.asList(
                this.magicCard,
                this.wowBoard,
                this.catanBoard,
                this.haloVideo,
                this.wowVideo,
                this.fortniteVideo
        ));

        // create our tree with our comparator
        Set<Game> gameTree = new TreeSet<>(new GameComparator());

        // add all the games to our tree
        gameTree.addAll(this.gameList);

        // test the order is correct
        int i = 0;
        for (Game game : gameTree) {
            assertEquals("\t" + i + " " + expectedOrder.get(i),
                    true,
                    game.equals(expectedOrder.get(i)),
                    "\twrong order " + expectedOrder.get(i).getName());
            ++i;
        }
    }

    /**
     * Test finding games in our collection using a HashSet.  This exercises
     * the Game method hashCode() along with equals() to quickly find the
     * game in question.
     */
    public void findGamesFast() {
        System.out.println("findGamesFast...");

        Set<Game> gameHash = new HashSet<>(this.gameList);

        for (Game game : gameHash) {
            assertEquals("\tfind " + game,
                    true,
                    gameHash.contains(game),
                    "\tcouldn't find " + game.getName());
        }

        // find same game with different cost - this is ok by our definition
        Game goodCatan = new Game("Settlers of Catan", 1995,
                19.99, Game.Type.BOARD);
        assertEquals("\tfind duplicate " + goodCatan,
                true,
                gameHash.contains(goodCatan),
                "\tcouldn't find " + goodCatan.getName());

        // can't find a game that doesn't exist in the collection
        Game tf2 = new Game("Team Fortress 2", 2007, 0.00,
                Game.Type.VIDEO);
        assertEquals("\tdon't find " + tf2,
                false,
                gameHash.contains(tf2),
                "\tcouldn't find " + tf2.getName() + "!");

        // be tricky and try to find a wrong copy of Fortnite
        List<Game> badGames = new ArrayList<>();
        badGames.add(new Game("Fortnite", 2001, 0, Game.Type.VIDEO));
        badGames.add(new Game("Fortnite", 2007, 0, Game.Type.CARD));

        for (Game badFortnite : badGames) {
            assertEquals("\tdon't find " + badFortnite,
                    false,
                    gameHash.contains(badFortnite),
                    "\tcouldn't find " + badFortnite.getName() + "!");
        }

        Game halo = null;
        gameHash.contains(halo);
    }

    /**
     * Test working with a HashMap and TreeMap.  Here we specify values for
     * the number of times a game has been played.
     */
    public void timesPlayed() {
        System.out.println("timesPlayed...");

        // create our map of games to number of times played
        Map<Game, Integer> playedMap = new HashMap<>();

        // for each game record the time it takes to play a game
        playedMap.put(this.catanBoard, 100);
        playedMap.put(this.fortniteVideo, 5000000);
        playedMap.put(this.magicCard, 600);
        playedMap.put(this.wowVideo, 9000);
        playedMap.put(this.haloVideo, 15000);
        playedMap.put(this.wowBoard, 5);

        // how many Fortnite games did you play during this recitation? :P
        playedMap.put(this.fortniteVideo,
                      playedMap.get(this.fortniteVideo) + 5);

        // make sure Halo 2 is in our collection
        assertEquals("\tfind key " + this.haloVideo,
                true,
                playedMap.containsKey(this.haloVideo),
                "\tcouldn't find " + this.haloVideo.getName());

        // make sure Risk is not in our collection
        Game riskBoard = new Game("Risk", 1957, 19.99,
                Game.Type.BOARD);
        assertEquals("\tdon't find key " + this.haloVideo,
                false,
                playedMap.containsKey(riskBoard),
                "\tcouldn't find " + riskBoard.getName());

        // what games did I play the most?  this only works if I don't
        // play any game the same amount of times
        Map<Integer, Game> timesMap = new TreeMap<>();
        for (Map.Entry<Game, Integer> entry : playedMap.entrySet()) {
            timesMap.put(entry.getValue(), entry.getKey());
        }

        // the expected order of games from least to most played
        List<Game> expectedOrder = new ArrayList<>(Arrays.asList(
                this.wowBoard,
                this.catanBoard,
                this.magicCard,
                this.wowVideo,
                this.haloVideo,
                this.fortniteVideo
        ));

        System.out.println("\tTimes played least to most:");
        // test the order is correct
        int i = 0;
        for (Map.Entry<Integer, Game> entry : timesMap.entrySet()) {
            assertEquals("\t\t" + i + " is " + expectedOrder.get(i) + "/"
                            + entry.getKey(),
                    true,
                    entry.getValue().equals(expectedOrder.get(i)),
                    "\t\twrong order " + expectedOrder.get(i).getName());
            ++i;
        }
    }

    /**
     * The main program creates the games and uses them in various
     * collections.
     *
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
        GameCollector collector = new GameCollector();

        // use the games in various ways
        collector.findGamesSlow();
        collector.orderGames();
        collector.orderGamesSpecial();
        collector.findGamesFast();
        collector.timesPlayed();
    }
}