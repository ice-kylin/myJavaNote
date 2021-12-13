package objectoriented.exer;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();

        p1.name = "Issac";
        p1.age = 19;
        p1.gender = 1;

        p1.study();
        System.out.println("p1.addAge(2)" + p1.addAge(2));
        p1.showAge();

        System.out.println();

        Person p2 = new Person();

        p2.showAge();
    }
}
