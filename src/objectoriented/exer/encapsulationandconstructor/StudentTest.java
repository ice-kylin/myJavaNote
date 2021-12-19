package objectoriented.exer.encapsulationandconstructor;

public class StudentTest {
    public static void main(String[] args) {
        StudentTest st = new StudentTest();

        Student s1 = new Student("Issac", 19);
        Student s2 = new Student("Acker", 19, "UoB");
        Student s3 = new Student("Icekylin", 19, "Uob", "CS");

        Student[] stds = new Student[]{s1, s2, s3};

        for (Student std : stds) {
            st.showStdInfo(std);
            System.out.println();
        }
    }

    public void showStdInfo(Student s) {
        System.out.println("name: " + s.getName());
        System.out.println("age: " + s.getAge());
        System.out.println("school: " + s.getSchool());
        System.out.println("major: " + s.getMajor());
    }
}
