package newfeatures.java8.stream;

import newfeatures.java8.Customer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
# Stream

- Stream 关注的是对数据的运算，与 CPU 打交道
- 集合关注的是数据的存储，与内存打交道
- Stream 自己不会存储元素
- Stream 不会改变源对象，相反，会返回一个持有结果的新 Stream
- Stream 操作是延迟执行的，这意味着它们会等到需要结果的时候才执行
- Stream 执行流程
  - Stream 的实例化
  - 一系列的中间操作（过滤、映射...）
    - 一个中间操作链。对数据源的数据进行处理
  - 终止操作
    - 一旦执行终止操作，就执行中间操作链，并产生结果，之后不会再被使用
 */
public class StreamTest {
    // 创建 Stream 方式 1：通过集合
    @Test
    public void test1() {
        List<String> strings = List.of("a", "b", "c");
        Stream<String> stream = strings.stream();
        Stream<String> parallelStream = strings.parallelStream();

        System.out.println(stream);
        System.out.println(parallelStream);
    }

    // 创建 Stream 方式 2：通过数组
    @Test
    public void test2() {
        int[] ints = {1, 2, 3, 4, 5};
        IntStream s1 = Arrays.stream(ints);

        System.out.println(s1);

        Customer[] customers = {
                new Customer(1001, "icekylin"),
                new Customer(1002, "Dupi")
        };

        Stream<Customer> s2 = Arrays.stream(customers);

        System.out.println(s2);
    }

    // 创建 Stream 方式 3：通过 Stream 的 of()
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        System.out.println(integerStream);
    }

    // 创建 Stream 方式 4：创建无限流
    @Test
    public void test4() {
        // 迭代
        Stream.iterate(
                        0, i -> i + 2
                )
                .limit(10)
                .forEach(System.out::println);

        System.out.println();

        // 生成
        Stream.generate(
                        Math::random
                )
                .limit(10)
                .forEach(System.out::println);
    }
}
