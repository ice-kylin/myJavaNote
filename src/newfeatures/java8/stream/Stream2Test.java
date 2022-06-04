package newfeatures.java8.stream;

import newfeatures.java8.Employee;
import newfeatures.java8.EmployeeData;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
# Stream 的终止操作
 */
public class Stream2Test {
    /*
    ## 1. 匹配与查找

    - forEach()：内部迭代
    - allMatch()：检查是否匹配所有的元素
     */
    // 是否所有员工的年龄都大于 18
    @Test
    public void test1() {
        boolean b = EmployeeData
                .getEmployees()
                .stream()
                .allMatch(
                        e -> e.getAge() > 18
                );

        System.out.println(b);
    }

    /*
    - anyMatch()：检查是否至少匹配一个元素
     */
    // 是否存在员工的工资大于 10000
    @Test
    public void test2() {
        boolean b = EmployeeData
                .getEmployees()
                .stream()
                .anyMatch(
                        e -> e.getSalary() > 10000
                );

        System.out.println(b);
    }

    /*
    - noneMatch()：检查是否没有匹配的元素
     */
    // 是否不存在员工姓“雷”
    @Test
    public void test3() {
        boolean b = EmployeeData
                .getEmployees()
                .stream()
                .noneMatch(
                        e -> e.getName().startsWith("雷")
                );

        System.out.println(b);
    }

    /*
    - findFirst：返回第一个元素
    - findAny：返回当前流中的任意元素
     */
    @Test
    public void test4() {
        Optional<Employee> first = EmployeeData
                .getEmployees()
                .stream()
                .findFirst();
        System.out.println(first);

        Optional<Employee> any = EmployeeData
                .getEmployees()
                .parallelStream()
                .findAny();
        System.out.println(any);
    }

    /*
    - count：返回流中元素的总个数
     */
    // 返回工资大于 5000 的员工的人数
    @Test
    public void test5() {
        long l = EmployeeData
                .getEmployees()
                .stream()
                .filter(
                        e -> e.getSalary() > 5000
                )
                .count();

        System.out.println(l);
    }

    /*
    - max()：返回流中最大值
     */
    // 返回最高的工资
    @Test
    public void test6() {
        Optional<Double> max = EmployeeData
                .getEmployees()
                .stream()
                .map(
                        Employee::getSalary
                ).max(
                        Double::compare
                );

        System.out.println(max);
    }

    /*
    - min()：返回流中最小值
     */
    // 返回最低工资的员工
    @Test
    public void test7() {
        Optional<Employee> min = EmployeeData
                .getEmployees()
                .stream()
                .min(
                        Comparator.comparingDouble(
                                Employee::getSalary
                        )
                );

        System.out.println(min);
    }

    /*
    ## 2. 归约

    - reduce(T identity, BinaryOperator<T> accumulator)：将流中元素反复结合起来，得到一个值，返回 T
     */
    // 计算 1 - 10 的自然数的和
    @Test
    public void test8() {
        Integer sum = Stream
                .iterate(
                        1, i -> i + 1
                ).limit(
                        10
                ).reduce(
                        0, Integer::sum
                );

        System.out.println(sum);
    }

    /*
    - reduce(BinaryOperator<T> accumulator)：将流中元素反复结合起来，得到一个值，返回 Optional<T>
     */
    // 计算公司所有员工工资的总和
    @Test
    public void test9() {
        Optional<Double> sum = EmployeeData
                .getEmployees()
                .stream()
                .map(
                        Employee::getSalary
                ).reduce(
                        Double::sum
                );

        System.out.println(sum);
    }

    /*
    ## 3. 收集

    - collect()：将流转换为其它形式，接受一个 Collector 接口的实现，用于给 Stream 中元素做汇总的方法
     */
    // 查找工资大于 6000 的员工，结果返回为一个 List 或 Set
    @Test
    public void test10() {
        List<Employee> employees = EmployeeData
                .getEmployees()
                .stream()
                .filter(
                        e -> e.getSalary() > 6000
                ).collect(
                        Collectors.toList()
                );

        Set<Employee> employees1 = EmployeeData
                .getEmployees()
                .stream()
                .filter(
                        e -> e.getSalary() > 6000
                ).collect(
                        Collectors.toSet()
                );

        employees.forEach(
                System.out::println
        );

        System.out.println();

        employees1.forEach(
                System.out::println
        );
    }
}
