package exception;

import org.junit.Test;

/*
# 异常处理

- 在 Java 语言中，将程序执行中发生的不正常情况称为“异常”（开发过程中的语法错误和逻辑错误不是异常）
- Java 程序在执行过程中所发生的异常事件可分为两类
  - `Error` —— Java 虚拟机无法解决的严重问题
    - 栈溢出：`java.lang.StackOverflowError`
    - 堆溢出：`java.lang.OutOfMemoryError`
    - ...
      - 不编写针对性的代码进行处理
  - `Exception` —— 其它因为编程错误或偶然的外在因素导致的一般性问题，可以使用针对性的代码进行处理
    - 空指针访问
    - 试图读取不存在的文件
    - 网络连接中断
    - 数组角标越界
    - ...
      - 编写针对性的代码进行处理

## 异常体系结构

- `java.lang.Error`
- `java.lang.Exception`
  - 编译时异常（checked）
    - `java.io.IOException`
      - `java.io.FileNotFoundException`
    - `java.lang.ClassNotFoundException`
  - `java.lang.RuntimeException`：运行时异常（unchecked）
    - `java.lang.NullPointerException`
    - `java.lang.ArrayIndexOutOfBoundsException`
    - `java.lang.ClassCastException`
    - `java.lang.NumberFormatException`
    - `java.lang.ArithmeticException`
 */
public class ExceptionTest {
    public static void main(String[] args) {
        // java.lang.StackOverflowError
        // main(args);
    }

    // java.lang.NullPointerException
    @Test
    public void test1() {
        int[] i = null;
        System.out.println(i[0]);
    }
}
