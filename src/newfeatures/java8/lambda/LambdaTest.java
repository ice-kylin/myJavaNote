package newfeatures.java8.lambda;

import org.junit.Test;

import java.util.Comparator;

/*
# Lambda 表达式

- 格式
  - `->`
    - Lambda 操作符
    - 箭头操作符
  - 左边：Lambda 形参列表（其实就是接口中的抽象方法的形参列表）
  - 右边：Lambda 体（其实就是重写的抽象方法的方法体）
- Lambda 表达式的使用（6 种情况）
  - 左边
    - Lambda 形参列表的参数类型可以省略（类型推断）
    - 如果 Lambda 形参列表只有一个参数，其 `()` 也可以省略
  - 右边
    - Lambda 体应使用一对 `{}` 包裹
    - 如果 Lambda 体只有一条执行语句（可能是 `return` 语句），可以省略这一对 `{}` 和 `return` 关键字
- Lambda 表达式的本质：作为接口的实例
- 如果一个接口中，只声明了一个抽象方法，则此接口就称为函数式接口
  - 可以在一个接口上使用 @FunctionalInterface 注解，这样可以检查它是否是一个函数式接口
  - 所以以前用匿名实现类表示的现在都可以用 Lambda 表达式来写
 */
public class LambdaTest {
    @Test
    public void test1() {
        Runnable runnable = () -> System.out.println("icekylin");

        runnable.run();
    }

    @Test
    public void test2() {
        // Lambda 表达式的写法
        Comparator<Integer> c1 = (i1, i2) -> i1.compareTo(i2);

        System.out.println(
                c1.compare(
                        2333,
                        6666
                )
        );

        // 方法引用
        Comparator<Integer> c2 = Integer::compareTo;

        System.out.println(
                c2.compare(
                        6666,
                        2333
                )
        );
    }
}
