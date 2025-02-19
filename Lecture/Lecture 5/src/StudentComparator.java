import java.util.Comparator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        int result = Double.compare(s2.getGpa(), s1.getGpa());
        if (result == 0) {
            return s1.getId() - s2.getId();
        }
        return result;
    }
}
