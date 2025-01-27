package interfaces;

public class TestShapes {
    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        Circle c2 = new Circle(15);
        Circle c3 = new Circle(10);

        System.out.println(c1);
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));

        //Shape s = new Shape();

        Shape s = new Circle(10);
        System.out.println(s.getArea());
        System.out.println(s.getPerimeter());
        //  System.out.println((s.getRadius);


    }
}
