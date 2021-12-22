package objectoriented.junit;

import org.junit.Test;

import java.util.Date;

/*
# 单元测试

## 步骤

1. add libraries
2. 创建 Java 测试类
  - 测试类要求
    1. 此类是 `public` 的
    2. 此类提供公共的无参的构造器
3. 此类中声明单元测试方法
  - 单元测试方法要求
    1. 方法的权限是 `public` 的
    2. 没有返回值
    3. 没有形参
4. 此单元测试上需要声明注解 `@Test`，并在单元测试类中导入 `import org.junit.Test;`
5. 声明好单元测试方法以后，就可以在方法体内测试相关的代码
6. 写完代码以后，左键双击单元测试方法名，右键运行

## 说明

1. 如果执行结果没有任何异常：绿条
2. 如果执行结果出现异常：红条
 */
public class JUnitTest {
    int num = 10;

    public void showMsg() {
        System.out.println("showMsg...");
    }

    @Test
    public void testEquals() {
        String s1 = "icekylin";
        String s2 = "icekylin";

        System.out.println(s1.equals(s2));

        System.out.println(num);

        showMsg();
    }

    @Test
    public void testCast() {
        Object o1 = "icekylin";
        Date d1 = (Date) o1;
    }
}
