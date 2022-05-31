package newfeatures.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class Lambda1Test {
    // 语法格式 1：无参、无返回值
    @Test
    public void test1() {
        Runnable runnable = () -> {
            System.out.println("icekylin");
        };

        runnable.run();
    }

    // 语法格式 2：Lambda 需要一个参数，但是没有返回值
    @Test
    public void test2() {
        Consumer<String> consumer = (String s) -> {
            System.out.println(s);
        };

        consumer.accept("icekylin");
    }

    // 语法格式 3：数据类型可以省略，因为可由编译器推断得出，称为类型推断
    @Test
    public void test3() {
        Consumer<String> consumer = (s) -> {
            System.out.println(s);
        };

        consumer.accept("icekylin");
    }

    // 语法格式 4：若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test4() {
        Consumer<String> consumer = s -> {
            System.out.println(s);
        };

        consumer.accept("icekylin");
    }

    // 语法格式 5：Lambda 需要两个或两个以上的参数，多条执行语句，并且可以有返回值
    @Test
    public void test5() {
        Comparator<Integer> c = (i1, i2) -> {
            System.out.println(i1);
            System.out.println(i2);
            return i1.compareTo(i2);
        };

        System.out.println(
                c.compare(233, 666)
        );
    }

    // 语法格式 6：当 Lambda 体只有一条语句时，return 与大括号都可以省略
    @Test
    public void test6() {
        Comparator<Integer> c = (i1, i2) -> i1.compareTo(i2);

        System.out.println(
                c.compare(233, 666)
        );
    }
}
