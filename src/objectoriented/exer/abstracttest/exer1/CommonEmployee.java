package objectoriented.exer.abstracttest.exer1;

public class CommonEmployee extends Employee {
    public CommonEmployee() {
    }

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("辛苦的工作");
    }
}
