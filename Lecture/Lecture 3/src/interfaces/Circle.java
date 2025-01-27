package interfaces;

public class Circle implements Shape, Comparable<Circle> {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Circle) {
            Circle other = (Circle) o;
            return this.radius == other.radius;
        }
        return false;
    }
    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }
    @Override
    public double getPerimeter(){
        return 2 * Math.PI * this.radius;
    }

    @Override
    public int compareTo(Circle o) {
        if(this.radius < o.radius){
            return -1;
        }else if (this.radius > o.radius){
            return 1;
        }else{
            return 0;
        }
    }
}
