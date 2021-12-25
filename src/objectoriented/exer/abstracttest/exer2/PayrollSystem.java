package objectoriented.exer.abstracttest.exer2;

import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Employee[] employees = new Employee[]{
                new SalariedEmployee("icekylin", 1001, new MyDate(2002, 7, 2), 50000),
                new HourlyEmployee("Issac", 1002, new MyDate(2002, 12, 24), 10, 200)
        };

        System.out.print("请输入当前月份：");
        int month = scanner.nextInt();

        for (Employee employee : employees) {
            System.out.println(employee);

            if (month == employee.getBirthday().getMonth()) {
                System.out.println("工资：" + (employee.earnings() + 100));
            } else {
                System.out.println("工资：" + employee.earnings());
            }
        }
    }
}
