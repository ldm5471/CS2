package interfaces;

import java.util.ArrayList;

public class    Polymorphism {

    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        Square s1 = new Square(5);
        Square s2 = new Square(8);

        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(c1);
        shapes.add(s1);
        shapes.add(s2);
        double totalArea = 0;
        for (Shape s: shapes){
            totalArea += s.getArea(); // polymorphism
        }
        System.out.println("Total area " + totalArea);
    }
}
