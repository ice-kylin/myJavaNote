package objectoriented.exer.encapsulationandconstructor;

public class Person {
    private int age;

    public void setAge(int a) {
        if (a > 0 && a <= 130) {
            age = a;
        }
    }

    public int getAge() {
        return age;
    }
}
