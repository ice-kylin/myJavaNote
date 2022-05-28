package reflection.person;

import annotation.MyAnnotation;

@MyAnnotation
public class Person<T> extends Animal implements Comparable<Person<T>> {
    public final int age;
    int pid;
    @MyAnnotation
    private String name;

    @MyAnnotation
    public Person() {
        age = 0;
    }

    public Person(String species, boolean gender, int id, String name, int age, int pid) {
        super(species, gender, id);
        this.name = name;
        this.age = age;
        this.pid = pid;
    }

    private Person(String name) {
        this.age = 0;
        this.name = name;
    }

    private static void showDesc() {
        System.out.println("我是一个人");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MyAnnotation("Java")
    @MyAnnotation("Python")
    public int getAge() {
        return age;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String show(String info) throws RuntimeException {
        System.out.println(info);
        return info;
    }

    @Override
    @MyAnnotation("hi")
    public int compareTo(Person o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }
}
