package reflection.person;

import annotation.MyAnnotation;

@MyAnnotation
public class Person<T> extends Animal implements Comparable<Person<T>> {
    @MyAnnotation
    private String name;
    public final int age;
    int pid;

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
}
