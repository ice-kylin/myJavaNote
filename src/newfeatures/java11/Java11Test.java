package newfeatures.java11;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

public class Java11Test {
    /*
    ## String 中新增的方法
     */
    @Test
    public void test1() {
        // isBlank()：判断字符串是否为空白
        System.out.println("".isBlank());
        System.out.println("   ".isBlank());
        System.out.println("\n".isBlank());

        // strip()：去除首尾空白
        System.out.println("  2333  ".strip());
        System.out.println("  2333  ".trim());

        // stripLeading()：去除首部空格
        // stripTrailing()：去除尾部空格
        System.out.println("*" + "  2333  ".stripLeading() + "*");
        System.out.println("*" + "  2333  ".stripTrailing() + "*");

        // repeat()：复制字符串
        System.out.println("abc".repeat(3));

        // lines().count()：判断行数
        System.out.println("a\nb\nc".lines().count());
    }

    /*
    ## Optional 新增的方法

    - isEmpty()：判断内部的 value 是否不存在
     */
    @Test
    public void test2() {
        Optional<Object> o = Optional.empty();

        System.out.println(o.isPresent()); // 判断内部的 value 是否存在
        System.out.println(o.isEmpty()); // 判断内部的 value 是否不存在
    }

    /*
    - orElseThrow()
      - value 非空，返回 value
      - 否则抛异常 NoSuchElementException
     */
    @Test
    public void test3() {
        Optional<Object> o = Optional.empty();

        try {
            Object o1 = o.orElseThrow();
            System.out.println(o1);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /*
    - ifPresentOrElse(Consumer<? super T> action, Runnable emptyAction)
      - value 非空，执行 action 功能
      - value 为空，执行 emptyAction 功能
    - or(Supplier<? extends Optional<? extends T>> supplier)
      - value 非空，返回对应 Optional
      - value 为空，返回形参封装的 Optional
     */
    @Test
    public void test4() {
        Optional<Object> o = Optional.empty();

        Optional<Object> o1 = o.or(
                () -> Optional.of("Hello")
        );

        System.out.println(o1);
    }

    /*
    ## 局部变量类型推断的升级
     */
    @Test
    public void test5() {
        Consumer<Object> con = (@Deprecated var o) -> System.out.println(o);

        con.accept("Hello World");
    }

    /*
    ## HttpClient 替换原有的 HttpURLConnection

    ## 更简化的编译运行程序

    - 执行源文件的第一个类，必须包含主方法
    - 不可以使用其它源文件中的自定义类，本文件中的自定义类是可以使用的
     */
}
