package newfeatures.java8.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/*
# 方法引用

- 使用情境：当要传递给 Lambda 体的操作已经有实现的方法了，可以使用方法引用
- 方法引用本质上就是 Lambda 表达式，而 Lambda 表达式作为函数式接口的实例
  - 所以方法引用也是函数式接口的实例
- 使用格式：类（或对象）:: 方法名
- 具体分为 3 种情况：
  - 对象 :: 非静态方法
  - 类 :: 静态方法
  - 类 :: 非静态方法
- 方法引用使用的要求
  - 要求接口种的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同（针对于情况 1 和情况 2）
 */
public class MethodReferencesTest {
    // 情况 1：对象 :: 非静态方法
    @Test
    public void test1() {
        PrintStream printStream = System.out;
        Consumer<String> con = printStream::println;

        con.accept("Hello World");
    }

    // 情况 2：类 :: 静态方法
    @Test
    public void test2() {
        Comparator<Integer> com = Integer::compare;
        System.out.println(com.compare(666, 233));
    }

    @Test
    public void test3() {
        Function<Double, Long> f = Math::round;
        System.out.println(f.apply(233.33));
    }

    // 情况 3：类 :: 非静态方法
    @Test
    public void test4() {
        Comparator<String> com = String::compareTo;
        System.out.println(com.compare("abc", "abd"));
    }

    @Test
    public void test5() {
        BiPredicate<String, String> BiPre = String::equals;
        System.out.println(
                BiPre.test(
                        "abc",
                        "abc"
                )
        );
    }
}
