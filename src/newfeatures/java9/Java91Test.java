package newfeatures.java9;

import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Java91Test {
    /*
    ## 增强的 Stream API
     */
    @Test
    public void test1() {
        List<Integer> integers = List.of(
                23,
                43,
                45,
                55,
                61,
                54,
                32,
                2,
                45,
                89,
                7
        );

        /*
        - takeWhile()：返回从开头开始的尽可能多的元素
         */
        integers
                .stream()
                .takeWhile(
                        i -> i < 60
                ).forEach(
                        System.out::println
                );

        System.out.println();

        /*
        - dropWhile()：行为与 takeWhile() 相反，返回剩余的元素
         */
        integers
                .stream()
                .dropWhile(
                        i -> i < 60
                ).forEach(
                        System.out::println
                );
    }

    /*
    - of()
      - 参数中的多个元素可以包含 null 值
      - 参数不能存储单个 null 值，否则报异常
    - ofNullable(T t)：形参变量可以为 null 值的单个元素
     */
    @Test
    public void test2() {
        Stream<Object> stream = Stream.ofNullable(null);
        Stream<Object> stream1 = Stream.ofNullable(null);

        stream.forEach(System.out::println);
        System.out.println(stream1.count()); // 0
    }

    /*
    - iterate(T seed, Predicate<? super T> hasNext, UnaryOperator<T> next)
      - JDK 9 中重载的新的方法
     */
    @Test
    public void test3() {
        Stream.iterate(
                0,
                i -> i <= 10,
                i -> i + 1
        ).forEach(
                System.out::println
        );
    }

    /*
    ## Optional 提供了新的方法 stream()
     */
    @Test
    public void test4() {
        List<String> strings = List.of("Tom", "Jerry", "Tim");
        Optional<List<String>> optionalStrings = Optional.of(strings);

        optionalStrings
                .stream()
                .flatMap(
                        Collection::stream
                ).forEach(
                        System.out::println
                );
    }
}
