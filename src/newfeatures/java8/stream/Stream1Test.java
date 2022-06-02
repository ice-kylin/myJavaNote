package newfeatures.java8.stream;

import newfeatures.java8.Employee;
import newfeatures.java8.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
# Stream 的中间操作
 */
public class Stream1Test {
    // 将字符串中的多个字符构成的集合转换为对应的 Stream 的实例
    public static Stream<Character> fromStringToStream(String s) {
        ArrayList<Character> cs = new ArrayList<>();

        for (char c : s.toCharArray()) {
            cs.add(c);
        }

        return cs.stream();
    }

    /*
    ## 1. 筛选与切片

    - filter()：接受 Lambda，从流中排除某些元素
     */
    // 查询员工表中工资大于 7000 的员工
    @Test
    public void test1() {
        Stream<Employee> stream = EmployeeData
                .getEmployees()
                .stream();

        stream.filter(
                e -> e.getSalary() > 7000
        ).forEach(
                System.out::println
        );
    }

    /*
    - limit()：截断流，使其元素不超过给定的数量
     */
    @Test
    public void test2() {
        EmployeeData
                .getEmployees()
                .stream()
                .limit(3)
                .forEach(
                        System.out::println
                );
    }

    /*
    - skip()：跳过元素，返回一个扔掉了前 n 个元素的流
      - 若流中的元素不足 n 个，则返回一个空流
     */
    @Test
    public void test3() {
        EmployeeData
                .getEmployees()
                .stream()
                .skip(3)
                .forEach(
                        System.out::println
                );
    }

    /*
    - distinct()：筛选，通过流所生成元素的 hashcode() 和 equals() 去除重复数据
     */
    @Test
    public void test4() {
        List<Employee> employees = EmployeeData.getEmployees();

        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 41, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));
        employees.add(new Employee(1010, "刘强东", 40, 8000));

        employees
                .stream()
                .distinct()
                .forEach(
                        System.out::println
                );
    }

    /*
    ## 2. 映射

    - map()
      - 接受一个函数作为参数，将元素转换成其它形式或提取信息
      - 该函数会被引用到每个元素上，并将其映射到一个新的元素上
     */
    @Test
    public void test5() {
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd", "ee");

        strings
                .stream()
                .map(String::toUpperCase)
                .forEach(
                        System.out::println
                );
    }

    // 获取员工姓名长度大于 3 的员工的姓名
    @Test
    public void test6() {
        EmployeeData
                .getEmployees()
                .stream()
                .map(Employee::getName)
                .filter(name -> name.length() > 3)
                .forEach(System.out::println);
    }

    /*
    - flatMap()：接收一个函数作为参数，将流中的每一个值都转换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test7() {
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd", "ee");

        strings
                .stream()
                .flatMap(
                        Stream1Test::fromStringToStream
                ).forEach(
                        System.out::println
                );
    }

    /*
    ## 3. 排序

    - sorted()：自然排序
    - sorted(Comparator<? super T> comparator)：定制排序
     */
    @Test
    public void test8() {
        List<Integer> integers = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);

        integers
                .stream()
                .sorted()
                .forEach(
                        System.out::println
                );
    }

    @Test
    public void test9() {
        EmployeeData
                .getEmployees()
                .stream()
                .sorted(
                        (e1, e2) -> {
                            int e1Age = e1.getAge();
                            int e2Age = e2.getAge();
                            if (e1Age > e2Age) {
                                return 1;
                            } else if (e1Age == e2Age) {
                                return e1
                                        .getName()
                                        .compareTo(
                                                e2.getName()
                                        );
                            } else {
                                return -1;
                            }
                        }
                )
                .forEach(
                        System.out::println
                );
    }
}
