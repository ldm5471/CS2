package inheritance;

/**
 * Simple class for testing the creation of Monsters and simulating
 * a fight between two monsters.
 *
 * @author CS RIT
 */
public class TestMonsters {

    public static void main(String[] args) {

        // Create Fighters
        Phoenix fawkes = new Phoenix("Fawkes", 80);
        Ogre shrek = new Ogre("Shrek", 90, "green");

        //Fight
        while(fawkes.getHitPoints() > 0 && shrek.getHitPoints() > 0) {
            fawkes.fly(15);
            fawkes.attack(shrek);
            if (shrek.getHitPoints() > 0) {
                shrek.attack(fawkes);
            }
            System.out.println(fawkes);
            System.out.println(shrek);
        }

        if (fawkes.getHitPoints() > 0) {
            System.out.println(fawkes.getName() + " is the winner");
        }else{
            System.out.println(shrek.getName() + " is the winner");
        }
    }
}


