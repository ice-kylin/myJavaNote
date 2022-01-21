package commonclass.string;

import org.junit.Test;

/*
# `String` 类
 */
public class StringOverviewTest {
    /*
    ## 说明

    - `String`：字符串，使用一对 `"` 引起来表示
    - `String` 声明为 `final` 的，不可被继承
    - `String` 实现了
      - `Serializable` 接口：表示字符串是支持序列化的
      - `Comparable` 接口：表示 `String` 可以比较大小
    - `String` 内部定义了 `private final byte[] value` 用于储存字符串数据
    - `String` 代表不可变的字符序列，简称不可变性
      - 当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的 `value` 进行赋值
      - 对现有的字符串进行连接操作时，需要重写指定内存区域赋值，不能使用原有的 `value` 进行赋值
      - 当调用 `String` 的 `replace()` 方法修改指定的字符或字符串时，也需要重新指定内存区域赋值
    - 通过字面量的方式（区别于 `new`）给一个字符串赋值，此时的字符串声明在字符串常量池中
    - 字符串常量池中是不会存储相同内容的字符串的
     */
    @Test
    public void test1() {
        String s1 = "icekylin"; // 字面量的定义方式
        String s2 = "icekylin";

        System.out.println("s1 == s2: " + (s1 == s2));

        s2 += "~";
        System.out.println("s1 == s2: " + (s1 == s2));

        String s3 = s2.replace('~', '!');
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
    }

    /*
    ## `String` 实例化的方式

    1. 通过字面量定义的方式
      - 数据声明在方法区中的字符串常量池中
    2. 通过 `new` + 构造器的方式
      - STFSC
     */
    @Test
    public void test2() {
        // 通过字面量定义的方式
        String s1 = "233";
        String s2 = "233";

        System.out.println("s1 == s2: " + (s1 == s2));

        // 通过 `new` + 构造器的方式
        String s3 = new String("233");
        String s4 = new String("233");

        System.out.println("s1 == s3: " + (s1 == s3));
        System.out.println("s3 == s4: " + (s3 == s4));
    }

    /*
    ## 结论

    - 常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量
    - 只要其中有一个是变量，结果就在堆中
    - 如果拼接的结果调用 `intern()` 方法，返回值就在常量池中
     */
    @Test
    public void test3() {
        String s1 = "Hello";
        String s2 = "World";

        String s3 = "HelloWorld";
        String s4 = "Hello" + "World";
        String s5 = s1 + "World";
        String s6 = "Hello" + s2;
        String s7 = s1 + s2;

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s3 == s7.intern());
    }
}
