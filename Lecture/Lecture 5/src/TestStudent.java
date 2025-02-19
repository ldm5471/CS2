import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TestStudent {

    public static void main(String[] args) {
        /** OLD VERSION
        Set<Student> studentSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int result = Double.compare(o2.getGpa(), o1.getGpa());
                if (result == 0) {
                    return o1.getId() - o2.getId();
                }
                return result;
            }
        });
         */
        Set<Student> studentSet = new TreeSet<>((o1,o2) -> {
                int result = Double.compare(o2.getGpa(), o1.getGpa());
                if (result == 0) {
                    return o1.getId() - o2.getId();
                }
                return result;
            }
        );
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
        studentSet.forEach((stu) -> {
            System.out.println(stu);
        });

        System.out.println("Printing using forEach with no curly braces");
        // forEach and lambda expression, without curly braces
        studentSet.forEach((stu) -> System.out.println(stu));

        System.out.println("Printing using forEach and method reference");
        //forEach and method reference
        studentSet.forEach(System.out::println);

        // printing students with a gpa higher than 3.5
        System.out.println("Filtering students using classic approach");
        studentSet.forEach((stu) ->{
            if (stu.getGpa() > 3.5){
                System.out.println(stu);
            }
        });

        // printing students with a gpa higher than 3.5 using Stream API
        System.out.println("Filtering students using Stream API");
        studentSet.stream()
                .filter(stu -> stu.getGpa() > 3.5)
                .filter(stu -> stu.getMajor().equals("CSEC"))
                .forEach(System.out::println);

        List<Student> result = studentSet.parallelStream()
                .filter(stu -> stu.getGpa() > 3.5)
                .filter(stu -> stu.getMajor().equals("CSEC"))
                .collect(Collectors.toList());
    }
}
