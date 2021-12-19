package objectoriented.exer.encapsulationandconstructor;

public class Student {
    private String name;
    private int age;
    private String school;
    private String major;

    public Student(String n, int a) {
        name = n;
        age = a;
    }

    public Student(String n, int a, String s) {
        name = n;
        age = a;
        school = s;
    }

    public Student(String n, int a, String s, String m) {
        name = n;
        age = a;
        school = s;
        major = m;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        age = a;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String s) {
        school = s;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String m) {
        major = m;
    }
}
