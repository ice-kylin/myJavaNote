package exception;

import org.junit.Test;

/*
# `finally`

- `finally` 是可选的
- `finally` 中声明的是一定会被执行的代码
   - 即使
     - `catch` 中又出现异常了
     - `try` 中有 `return` 语句
     - `catch` 中有 `return` 语句等情况
- 像数据库连接、输入输出流、网络编程 Socket 等资源，JVM 是不能自动回收的，需要手动的进行资源释放
  - 此时资源的释放就需要声明在 `finally` 中
 */
public class FinallyTest {
    @Test
    public void test1() {
        try {
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("az...");
        } finally {
            System.out.println("233...");
        }
    }

    public int m1() {
        try {
            int a = 10;
            int b = 0;
            int c = a / b;
            return 1;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("az...");
            return 2; // `catch` 中有 `return` 语句
        } finally {
            System.out.println("233...");
        }
    }

    @Test
    public void test2() {
        System.out.println(m1());
    }

    @Test
    public void test3() {
        try {
            int a = 10;
            int b = 0;
            int c = a / b;
        } catch (ArithmeticException e) {
            e.printStackTrace();
            int i = 10 / 0; // `catch` 中又出现异常了
            System.out.println("az...");
        } finally {
            System.out.println("233...");
        }
    }
}
