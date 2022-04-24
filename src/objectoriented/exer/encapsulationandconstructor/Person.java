package objectoriented.exer.encapsulationandconstructor;

public class Person {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int a) {
        if (a > 0 && a <= 130) {
            age = a;
        }
    }
}
