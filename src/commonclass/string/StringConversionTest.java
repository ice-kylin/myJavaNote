package commonclass.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
# `String` 与数组之间的转换
 */
public class StringConversionTest {
    /*
    ## `String` 与 `char[]` 之间的转换

    - `toCharArray()`：`String` -> `char[]`
    - 构造器 `String(char value[])`：`char[]` -> `String`
     */
    @Test
    public void test() {
        String s1 = "HelloWorld";

        char[] cs1 = s1.toCharArray();

        for (int i = 0; i < cs1.length; i++) {
            System.out.println(i + 1 + ": " + cs1[i]);
        }

        String s2 = new String(new char[]{'J', 'a', 'v', 'a'});

        System.out.println("s2 = " + s2);
    }

    /*
    ## `String` 与 `byte[]` 之间的转换

    - `byte[] getBytes()`：`String` -> `byte[]`
      - 编码：字符串 -> 字节（看得懂的 -> 看不懂的）
    - 构造器
      - 解码：编码的逆过程，字节 -> 字符串（看不懂的 -> 看得懂的）
     */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String s1 = "HelloWorld";

        byte[] bs1 = s1.getBytes(); // 使用默认的字符集进行编码

        for (int i = 0; i < bs1.length; i++) {
            System.out.println(i + 1 + ": " + bs1[i]);
        }

        String s2 = "中国";

        byte[] bs2 = s2.getBytes(); // 使用默认的字符集进行编码
        byte[] bs3 = s2.getBytes("gbk");

        System.out.println("bs2 = " + Arrays.toString(bs2));
        System.out.println("bs2 = " + Arrays.toString(bs3));

        System.out.println();

        String s3 = new String(bs2); // 使用默认的字符集进行解码
        String s4 = new String(bs3); // 使用默认的字符集进行解码
        String s5 = new String(bs3, "gbk");

        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4); // 出现乱码（原因：编码集和解码集不一致）
        System.out.println("s5 = " + s5); // 没有出现乱码（原因：编码集和解码集一致）
    }
}
