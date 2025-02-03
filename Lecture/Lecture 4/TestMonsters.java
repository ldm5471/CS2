package inheritance;

/**
 * Simple class for testing the creation of Monsters and simulating
 * a fight between two monsters.
 *
 * @author CS RIT
 */
public class TestMonsters {

    public static void main(String[] args) {

        Phoenix fawkes = new Phoenix("Fawkes", 80);
        // Print out Monsters
        System.out.println(fawkes);

        // show how different objects work
        Monster m = fawkes;
        m.takeDamage(15);
        fawkes.fly(30);

    }
}


