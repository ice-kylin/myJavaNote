package commonclass.string;

import org.junit.Test;

import java.util.Locale;

/*
# `String` 常用方法
 */
public class StringMethodTest {
    /*
    `int length()`：返回字符串的长度
     */
    @Test
    public void test1() {
        String s1 = "Hello World!";
        System.out.println("s1.length() = " + s1.length());
    }

    /*
    `char charAt()`：返回指定索引处的字符
     */
    @Test
    public void test2() {
        String s1 = "Hello World!";
        System.out.println("s2.charAt(s2.length() - 1) = " + s1.charAt(s1.length() - 1));
        System.out.println("s2.charAt(0) = " + s1.charAt(0));
    }

    /*
    `boolean isEmpty()`：判断是否是空字符串
     */
    @Test
    public void test3() {
        String s1 = "Hello World!";
        String s2 = "";
        String s3 = " ";
        System.out.println("s1.isEmpty() = " + s1.isEmpty());
        System.out.println("s2.isEmpty() = " + s2.isEmpty());
        System.out.println("s3.isEmpty() = " + s3.isEmpty());
    }

    /*
    - `String toLowerCase()`：使用默认语言环境，将 `String` 中的所有字符转换为小写
    - `String toLowerCase()`：使用默认语言环境，将 `String` 中的所有字符转换为大写
     */
    @Test
    public void test4() {
        String s1 = "Hello World!";
        String s2 = s1.toLowerCase();
        String s3 = s1.toUpperCase();

        System.out.println("s1 = " + s1); // s1 不可变，仍然为原来的字符串
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
    }

    /*
    `String trim()`：返回字符串的副本，忽略前导空白和尾部空白
     */
    @Test
    public void test5() {
        String s1 = "   Hello   World!   ";
        String s2 = s1.trim();

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
    }

    /*
    - `boolean equals()`：比较字符串的内容是否相同
    - `boolean equalsIgnoreCase()`：与 `equals()` 方法类似，忽略大小写
     */
    @Test
    public void test6() {
        String s1 = "Hello World!";
        String s2 = "Hello World!";
        String s3 = s1.toUpperCase();

        System.out.println("s1.equals(s2) = " + s1.equals(s2));
        System.out.println("s1.equals(s3) = " + s1.equals(s3));
        System.out.println("s1.equalsIgnoreCase(s3) = " + s1.equalsIgnoreCase(s3));
    }
}
