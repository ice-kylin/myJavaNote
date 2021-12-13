package objectoriented.exer;

public class Person {
    String name;
    int age;
    int gender;

    public void study() {
        System.out.println("Studying");
    }

    public void showAge() {
        System.out.println("age = " + age);
    }

    public int addAge(int i) {
        age += i;
        return age;
    }
}
