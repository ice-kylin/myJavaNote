package exception;

public class StudentTest {
    public static void main(String[] args) {
        try {
            Student s = new Student("Issac", 0);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            Student s = new Student("Issac", 233);
            System.out.println(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Student {
    private String name;
    private int id;

    public Student() {
        id = 1;
    }

    public Student(String name, int id) throws Exception {
        this.name = name;
        if (id > 0) {
            this.id = id;
        } else {
            throw new Exception("id 小于 0");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) throws Exception {
        if (id > 0) {
            this.id = id;
        } else {
            throw new Exception("id 小于 0");
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
