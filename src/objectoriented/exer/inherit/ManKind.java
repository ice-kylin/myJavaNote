package objectoriented.exer.inherit;

public class ManKind {
    private int sex;
    private int salary;

    public ManKind() {
    }

    public ManKind(int sex, int salary) {
        this.sex = sex;
        this.salary = salary;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public ManKind manOrWomen() {
        if (getSex() == 1) {
            System.out.println("man");
        } else {
            System.out.println("women");
        }

        return this;
    }

    public ManKind employeed() {
        if (getSalary() == 0) {
            System.out.println("no job");
        } else {
            System.out.println("job");
        }

        return this;
    }
}
