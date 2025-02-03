package inheritance;

/**
 * A basic monster with a name and hit points.
 *
 * @author CS RIT
 */
public abstract class Monster {

    private final String name;
    private int hitPoints;

    public Monster(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    public String getName() {
        return name;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void updateHitPoints(int hitPoints) {
        this.hitPoints += hitPoints;
        if (this.hitPoints < 0){
            this.hitPoints = 0;
        }
    }

    public void takeDamage(int amount){
        System.out.println(getName() + " takes " + amount + " damage");
        updateHitPoints(-amount);
        if (hitPoints <= 0){
            System.out.println(getName() + " fainted!!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Monster)) return false;
        Monster other = (Monster) o;
        return hitPoints == other.hitPoints && name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Monster{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                '}';
    }
}
