package inheritance;

/**
 * The mighty Phoenix possesses the power of flight and can regenerate
 * hit points when taking damage if the damage is non-critical.
 *
 * @author CS RIT
 */
public class Phoenix extends Monster implements Flyer {
    /**
     * how far has this phoenix flown?
     */
    private int distance;

    public Phoenix(String name, int hitPoints) {
        this.distance = 0;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public void fly(int distance) {
        this.distance += distance;
    }

    @Override
    public String toString() {
        return "Phoenix{distance=" + distance + "}";
    }

}