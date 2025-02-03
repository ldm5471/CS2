package inheritance;

/**
 * Simple Ogre class definition to illustrate abstract classes.
 *
 * @author CS RIT
 */
public class Ogre {

    private final String color;

    public Ogre(String name, int hitPoints, String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Ogre{" +
                "color='" + color + '\'' +
                '}';
    }
}
