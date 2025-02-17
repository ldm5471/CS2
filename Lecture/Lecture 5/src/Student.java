public class Student implements Comparable<Student>{

    private final String name;
    private final int id;
    private final double gpa;
    private final String major;

    public Student(String name, int id, double gpa, String major) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student){
            Student other = (Student) o;
            return this.id == other.id;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gpa=" + gpa +
                ", major='" + major + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.id - o.id;
    }
}
