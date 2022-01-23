package commonclass.string;

import org.junit.Test;

/*
# `String` 常用方法 2

- `boolean endsWith()`：测试此字符串是否以指定的后缀结束
- `boolean startsWith(String prefix)`：测试此字符串是否以指定的前缀开始
- `boolean startsWith(String prefix, int toffset)`：测试此字符串从指定的索引开始的子字符串是否以指定的前缀开始
- `boolean contains()`：当且仅当此字符串包含指定的 char 值序列时，返回 `true`
- `int indexOf(String str)`：返回指定子字符串在此字符串中第一次出现处的索引
- `int indexOf(String str, int fromIndex)`：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始搜索
- `int lastIndexOf(String str)`：返回指定子字符串在此字符串中最右边出现处的索引
- `int lastIndexOf(String str)`：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
  - `indexOf()` 和 `lastIndexOf()` 方法如果没找到返回值都是 `-1`
 */
public class StringMethod1Test {
    /*
    - `boolean endsWith()`：测试此字符串是否以指定的后缀结束
    - `boolean startsWith(String prefix)`：测试此字符串是否以指定的前缀开始
    - `boolean startsWith(String prefix, int toffset)`：测试此字符串从指定的索引开始的子字符串是否以指定的前缀开始
     */
    @Test
    public void test1() {
        String s1 = "HelloWorld!";

        boolean b1 = s1.endsWith("ld!");
        boolean b2 = s1.startsWith("Hel");
        boolean b3 = s1.endsWith("LD!");
        boolean b4 = s1.startsWith("hel");


        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
        System.out.println("b3 = " + b3);
        System.out.println("b4 = " + b4);

        boolean b5 = s1.startsWith("llo", 2);
        boolean b6 = s1.startsWith("LLO", 2);

        System.out.println("b5 = " + b5);
        System.out.println("b6 = " + b6);
    }

    /*
    `boolean contains()`：当且仅当此字符串包含指定的 char 值序列时，返回 `true`
     */
    @Test
    public void test2() {
        String s1 = "HelloWorld!";

        boolean b1 = s1.contains("Wor");
        boolean b2 = s1.contains("wor");

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
    }

    /*
    - `int indexOf(String str)`：返回指定子字符串在此字符串中第一次出现处的索引
    - `int indexOf(String str, int fromIndex)`：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始搜索
    - `int lastIndexOf(String str)`：返回指定子字符串在此字符串中最右边出现处的索引
    - `int lastIndexOf(String str)`：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索
      - `indexOf()` 和 `lastIndexOf()` 方法如果没找到返回值都是 `-1`
     */
    @Test
    public void test3() {
        String s1 = "HelloWorld!";

        int i1 = s1.indexOf("lo");
        int i2 = s1.indexOf("lol");

        System.out.println("i1 = " + i1);
        System.out.println("i1 = " + i2);


        int i3 = s1.indexOf("lo", 5);

        System.out.println("i3 = " + i3);

        int i4 = s1.lastIndexOf("lo");
        int i5 = s1.lastIndexOf("lol");

        System.out.println("i4 = " + i4);
        System.out.println("i5 = " + i5);

        int i6 = s1.lastIndexOf("lo", 5);

        System.out.println("i6 = " + i6);
    }
}
