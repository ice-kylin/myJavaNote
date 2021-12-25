package objectoriented.exer.abstracttest.exer1;

public class EmployeeTest {
    public static void main(String[] args) {
        Manager m1 = new Manager("icekylin", 1001, 5000, 50000);
        m1.work();
        System.out.println(m1.getBonus());

        CommonEmployee c1 = new CommonEmployee("Issac", 1002, 5000);
        c1.work();
    }
}
