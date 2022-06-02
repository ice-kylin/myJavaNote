package newfeatures.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeData {
    public static List<Employee> getEmployees() {
        return new ArrayList<>(
                Arrays.asList(
                        new Employee(1001, "马化腾", 34, 6000.38),
                        new Employee(1002, "马云", 12, 9876.12),
                        new Employee(1003, "刘强东", 33, 3000.82),
                        new Employee(1004, "雷军", 26, 7657.37),
                        new Employee(1005, "李彦宏", 65, 5555.32),
                        new Employee(1006, "比尔盖茨", 42, 9500.43),
                        new Employee(1007, "任正非", 26, 4333.32),
                        new Employee(1008, "扎克伯格", 356, 2500.32)
                )
        );
    }
}
