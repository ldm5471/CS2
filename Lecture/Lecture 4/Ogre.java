package inheritance;

/**
 * Simple Ogre class definition to illustrate abstract classes.
 *
 * @author CS RIT
 * @author Luke Maeurer
 */
public class Ogre extends Monster {

    private final String color;

    public Ogre(String name, int hitPoints, String color) {
        super(name, hitPoints);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void attack(Monster other){
        System.out.println(getName() + " bonks " + other.getName() + " *belch*");
        other.takeDamage(30);
    }
    @Override
    public String toString() {
        return super.toString() + ", Ogre{" +
                "color='" + color + '\'' +
                '}';
    }
}
