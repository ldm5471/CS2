package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortCircles {

    public static void main(String[] args) {
        Circle big = new Circle(15);
        Circle medium = new Circle(10);
        Circle small = new Circle(5);

        List<Circle> circles = new ArrayList<>();
        circles.add(big);
        circles.add(medium);
        circles.add(small);
        Collections.sort(circles);
        System.out.println(circles);
    }
}
