package newfeatures.java9;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Java9Test {
    /*
    ## 钻石操作符的升级使用
     */
    @Test
    public void test1() {
        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };

        System.out.println(comparator.compare("a", "b"));
    }

    /*
    ## try 操作的升级
     */
    // JDK 8 中资源的关闭操作
    // 要求自动关闭的资源的初始化必须放在 try 的一对小括号中
    @Test
    public void test2() {
        try (
                InputStreamReader reader = new InputStreamReader(System.in)
        ) {
            char[] cBuf = new char[16];
            int len;
            if (
                    (len = reader.read(cBuf)) != -1
            ) {
                System.out.println(
                        new String(
                                cBuf,
                                0,
                                len
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // JDK 9 中资源的关闭操作
    // 需要自动关闭的资源的实例化可以放在 try 的一对小括号外
    // 此时的资源属性是常量，声明为 final，不可修改
    @Test
    public void test3() {
        InputStreamReader reader = new InputStreamReader(System.in);
        try (reader) {
            char[] cBuf = new char[16];
            int len;
            if (
                    (len = reader.read(cBuf)) != -1
            ) {
                System.out.println(
                        new String(
                                cBuf,
                                0,
                                len
                        )
                );
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
