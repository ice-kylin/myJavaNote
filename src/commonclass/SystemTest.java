package commonclass;

import org.junit.Test;

/*
# `System` 类

- 代表系统，系统级的很多属性和控制方法都放置在该类的内部
- 该类的构造器是 `private` 的，无法创建该类的对象
  - 其内部成员变量和方法都是 `static` 的，所以可以很方便的进行调用

## 成员变量

- `in`、`out`、`err`：分别代表标准输入流（键盘输入）、标准输出流（显示器）和标准错误输出流（显示器）

## 成员方法

- `native long currentTimeMillis()
- `static void exit(int status)`
  - 退出程序
    - `status` 为 `0` 表示正常退出，非零表示异常退出
    - 使用该方法可以在图形界面编程中实现程序的退出功能等
- `gc()`
- `String getProperty(String key)`
  - 获取系统中属性名为 `key` 的属性对应的值
 */
public class SystemTest {
    @Test
    public void test1() {
        String javaVersion = System.getProperty("java.version");
        String javaHome = System.getProperty("java.home");
        String osName = System.getProperty("os.name");
        String osVersion = System.getProperty("os.version");
        String userName = System.getProperty("user.name");
        String userHome = System.getProperty("user.home");
        String userDir = System.getProperty("user.dir");

        System.out.println("javaVersion = " + javaVersion);
        System.out.println("javaHome = " + javaHome);
        System.out.println("osName = " + osName);
        System.out.println("osVersion = " + osVersion);
        System.out.println("userName = " + userName);
        System.out.println("userHome = " + userHome);
        System.out.println("userDir = " + userDir);
    }
}
