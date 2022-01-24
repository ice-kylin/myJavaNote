package commonclass.string;

import org.junit.Test;

/*
# `StringBuffer` 和 `StringBuilder`

## `String`、`StringBuffer` 和 `StringBuilder` 三者之间的异同

- `String`
  - 不可变的字符序列
  - 底层数组使用 byte[] 存储
- `StringBuffer`
  - 可变的字符序列
  - 不可变的字符序列
  - 线程安全的，效率低
- `StringBuilder`
  - 可变的字符序列
  - 不可变的字符序列
  - 线程不安全的，效率高

## 源码分析

```java
String str = new String(); // byte[] value = new byte[0];
String str1 = new String("abc"); // byte[] value = new byte[3];

StringBuffer sb1 = new StringBuffer(); // byte[] value = new byte[16];
StringBuffer sb2 = new StringBuffer("abc"); // byte[] value = new byte["abc".length + 16];
```

## 扩容情况

- 如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组
  - 默认情况下，扩容为原来容量的 2 倍 + `2`
  - 同时将原有数组中的元素复制到新的数组中
- 指导意义
  - 开发中建议使用
    - `StringBuffer(int capacity)`
    - `StringBuilder(int capacity)`

## `StringBuilder` 的常用方法

- `StringBuilder append(xxx)`：提供了很多的 `append()` 方法，用于进行字符串的拼接
- `StringBuilder delete(int start, int end)`：删除指定位置的内容
- `StringBuilder replace(int start, int end, String str)`：把 [start, end) 位置替换为 `str`
- `StringBuilder insert(int offset, xxx)`：在指定位置插入 `xxx`
- `StringBuilder reverse()`：把当前的字符序列逆转
- `int indexOf(String str)`
- `String substring(int start, int end)`
- `int length()`
- `char charAt(int index)`
- `void setCharAt(int index, char ch)`

### 总结

- 增：`append()`
- 删：`delete()`
- 改
  - `setCharAt()`
  - `replace()`
- 查：`charAt()`
- 插：`insert()`
- 长度：`length()`

## `String`、`StringBuffer` 和 `StringBuilder` 三者的效率（从高到低）

1. `StringBuilder`
2. `StringBuffer`
3. `String`
 */
public class StringBufferBuilderTest {
    /*
    - `StringBuilder append()`：提供了很多的 `append()` 方法，用于进行字符串的拼接
    - `StringBuilder delete(int start, int end)`：删除指定位置的内容
    - `StringBuilder replace(int start, int end, String str)`：把 [start, end) 位置替换为 `str`
    - `StringBuilder insert(int offset, xxx)`：在指定位置插入 `xxx`
    - `StringBuilder reverse()`：把当前的字符序列逆转
     */
    @Test
    public void test1() {
        StringBuilder sb1 = new StringBuilder();

        sb1.append("Hello");
        sb1.append("World");
        sb1.append('!');

        System.out.println("sb1 = " + sb1);

        sb1.delete(5, 10);
        System.out.println("sb1 = " + sb1);

        sb1.replace(5, 5, "Java");
        System.out.println("sb1 = " + sb1);

        sb1.insert(5, " ");
        System.out.println("sb1 = " + sb1);

        sb1.reverse();
        System.out.println("sb1 = " + sb1);
    }

    /*
    - `int indexOf(String str)`
    - `String substring(int start, int end)`
    - `int length()`
    - `char charAt(int index)`
    - `void setCharAt(int index, char ch)`
     */
    @Test
    public void test2() {
        StringBuilder sb1 = new StringBuilder("HelloWorld!");

        System.out.println("sb1.indexOf(\"Wor\") = " + sb1.indexOf("Wor"));

        String s1 = sb1.substring(0, 5);
        System.out.println("s1 = " + s1);

        int i1 = sb1.length();
        System.out.println("i1 = " + i1);

        char c1 = sb1.charAt(5);
        System.out.println("c1 = " + c1);

        sb1.setCharAt(sb1.length() - 1, '~');
        System.out.println("sb1 = " + sb1);
    }
}
