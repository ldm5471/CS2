public class Duck implements Animal,Flyer,Swimmer{
    public static final double FLY_SPEED_MS = 22.352;
    public static final double RUN_SPEED_MS = 13.94765;
    public static final double SWIN_SPEED_MS = 26.8224;
    private double wingSpan;
    private int happiness;

    public Duck(double wingSpan){
        this.wingSpan = wingSpan;
        happiness = 0;
    }
    public void pet(int seconds){
        this.happiness += seconds*wingSpan;

    }
    public int getHappiness(){
        return happiness;
    }
    @Override
    public double run(int seconds){
        return seconds*RUN_SPEED_MS + wingSpan;
    }
    @Override
    public String speak(){
        return this.toString() + " says \"quack!, quack!\"";
    }
    @Override
    public double dive(int minutes){
        return minutes*SWIN_SPEED_MS;
    }
    @Override
    public double fly(int seconds){
        return seconds*FLY_SPEED_MS*wingSpan;
    }
    @Override
    public String toString() {
        return "Duck{wingSpan=" + this.wingSpan + ", happiness=" + this.happiness + '}';
    }
}