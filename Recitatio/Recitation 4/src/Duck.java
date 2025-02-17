public class Duck extends Animal implements Flyer, Swimmer {
    public static final double FLY_SPEED_MS = 22.352;
    public static final double RUN_SPEED_MS = 13.94765;
    public static final double SWIM_SPEED_MS = 26.8224;
    private double wingSpan;
    private int happiness;

    public Duck(double wingSpan,String name){
        super(name);
        this.wingSpan = wingSpan;
        this.happiness = 0;
    }

    public void pet(int seconds){
        this.happiness += seconds*wingSpan;
    }

    public int getHappiness(){
        return happiness;
    }

    @Override
    public void run(int seconds) {
        travel(seconds*RUN_SPEED_MS+this.wingSpan);
    }

    @Override
    public String speak() {
        return toString() + "says \"quack! quack!\"";
    }

    @Override
    public void fly(int seconds) {
        travel(seconds*FLY_SPEED_MS*this.wingSpan);
    }

    @Override
    public void dive(int minutes) {
        travel(minutes*SWIM_SPEED_MS);
    }

    @Override
    public int getFishEaten() {
        return 0;
    }

    @Override
    public String toString(){
        return super.toString() + "Duck{wingSpan=" + wingSpan + ", happiness=" + happiness + "}}";
    }
}
