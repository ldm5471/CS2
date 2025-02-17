/**
 * CSCI-142 Computer Science 3 Recitation Presentation
 * 05-JCF1
 * Game
 *
 * A class to represent a game that is ideal for storage in the various
 * JCF collection classes.
 *
 * @author RIT CS
 */
public class Game implements Comparable<Game> {
    /** the kind of game */
    public enum Type {
        CARD,
        BOARD,
        VIDEO
    }

    /** the name of the game */
    private String name;
    /** the year the game was invented */
    private int year;
    /** the cost of the game */
    private double cost;
    /** the type of game */
    private Type type;

    /**
     * Create a new game.
     *
     * @param name the name
     * @param year the year invented
     * @param cost the cost of the game
     * @param type the type of game
     */
    public Game(String name, int year, double cost, Type type) {
        this.name = name;
        this.year = year;
        this.cost = cost;
        this.type = type;
    }

    /**
     * Get the name of the game.
     *
     * @return the name
     */
    public String getName() { return this.name; }

    /**
     * Get the year the game was invented.
     *
     * @return the game's year
     */
    public int getYear() {  return this.year; }

    /**
     * Get the cost of the game.
     *
     * @return the game's cost
     */
    public double getCost() { return this.cost; }

    /**
     * Get the type of game.
     *
     * @return game type
     */
    public Type getType() { return this.type; }

    /**
     * Two games are equal if they have the same name, were invented in
     * the same year, and are the same type of game
     *
     * @param other the other object to compare this game to
     * @return whether they are equal or not
     */
    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Game) {
            Game otherGame = (Game) other;
            result = this.name.equals(otherGame.name) &&
                     this.year == otherGame.year &&
                     this.type == otherGame.type;
        }
        return result;
    }

    /**
     * Games are naturally ordered by the year invented.  If they are the
     * same the tiebreaker is alphabetically by name.
     *
     * @param other the game to compare to
     * @return a value less than 0 if this game is less than the other,
     * 0 if the games are equal, or a value greater than 0 if this
     * game is greater than the other
     */
    @Override
    public int compareTo(Game other) {
        int result = this.year - other.year;
        if (result == 0) {
            result = this.name.compareTo(other.name);
        }
        return result;
    }

    /**
     * To be consistent with equals, the hash code of a game is the hash
     * code of the name, plus the year, plus the hash code of the game type.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        return this.name.hashCode() + this.year + this.type.hashCode();
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", cost=" + cost +
                ", type=" + type +
                '}';
    }
}