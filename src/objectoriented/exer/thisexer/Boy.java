package objectoriented.exer.thisexer;

public class Boy {
    private String name;
    private int age;

    public Boy(String name, int age) {
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

    public void marry(Girl girl) {
        girl.marry(this);
    }

    public void shout() {
        if (age >= 22) {
            System.out.println(name + " 可以结婚了！");
        } else {
            System.out.println(name + " 不能结婚！");
        }
    }
}
