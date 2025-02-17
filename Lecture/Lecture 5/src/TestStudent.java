import java.util.Set;
import java.util.TreeSet;

public class TestStudent {

    public static void main(String[] args) {
        Set<Student> studentSet = new TreeSet<>();
        studentSet.add(new Student("Steven", 1, 3.65, "CMPE"));
        studentSet.add(new Student("Sara", 2, 3.4, "CSEC"));
        studentSet.add(new Student("Lee", 3, 3.8, "SWEN"));
        studentSet.add(new Student("Sky", 4, 3.2, "CSCI"));
        studentSet.add(new Student("Heather", 5, 3.4, "CSCI"));
        studentSet.add(new Student("Duncan", 6, 3.9, "SWEN"));
        studentSet.add(new Student("Jessica", 7, 3.9, "CSEC"));
        studentSet.add(new Student("Julia", 8, 3.9, "MATH"));

        // enhanced for loop
        for (Student s : studentSet) {
            System.out.println(s);
        }

        System.out.println("Printing using forEach");
        // forEach and lambda expression
        //TODO

        System.out.println("Printing using forEach with no curly braces");
        // forEach and lambda expression, without curly braces
        //TODO 

        System.out.println("Printing using forEach and method reference");
        //forEach and method reference
        // TODO

        // printing students with a gpa higher than 3.5
        System.out.println("Filtering students using classic approach");
        //TODO

        // printing students with a gpa higher than 3.5 using Stream API
        System.out.println("Filtering students using Stream API");
        //TODO
    }
}
