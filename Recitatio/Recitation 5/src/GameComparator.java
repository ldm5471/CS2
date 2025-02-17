import java.util.Comparator;

/**
 * CSCI-142 Computer Science 3 Recitation Presentation
 * 05-JCF1
 * Game
 *
 * A custom Game comparator that compares games first by type (as listed in
 * the Game.Type enum), and second by decreasing cost.
 *
 * @author RIT CS
 */
public class GameComparator implements Comparator<Game> {

    /**
     * Compare games first by type (as listed in Game.Type enum)
     * and second by decreasing order.
     *
     * @param first first game to compare
     * @param second second game to compare
     * @return less than 0 if first is less than second, 0 if they are
     * equal, greater than 0 if first is greater than second
     */
    @Override
    public int compare(Game first, Game second) {
        // Java enums implement the Comparable interface and they order by
        // how they are listed in the enum.
        int result = first.getType().compareTo(second.getType());
        if (result == 0) {
            // we swap the order of the costs to get largest to smallest
            result = Double.compare(second.getCost(), first.getCost());
        }
        return result;
    }
}