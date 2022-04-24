package objectoriented.exer.thisexer;

public class Girl {
    private String name;
    private int age;

    public Girl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Boy boy) {
        System.out.println(name + " 和 " + boy.getName() + " 结婚了！");
    }

    public int compare(Girl girl) {
        return this.getAge() - girl.getAge();
    }
}
