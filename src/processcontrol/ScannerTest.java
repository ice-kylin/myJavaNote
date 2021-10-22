package processcontrol;
/*
# `Scanner`

- 从键盘获取不同类型的变量，需要使用 `Scanner` 类

## 实现步骤

1. 导包：`import java.util.Scanner;`
2. `Scanner` 的实例化：`Scanner scanner = new Scanner(System.in);`
3. 调用 `Scanner` 类的相关方法，来获取指定类型的变量、

## 注意

- 需要根据相应的方法，来输入指定类型的值
- 如果输入的数据类型与要求的类型不匹配时，会抛出异常 `InputMisMatchException`
- 导致程序终止
 */

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入您的名字：");
        String name = scanner.next();
        System.out.println("name = " + name);

        System.out.println("请输入您的年龄：");
        int age = scanner.nextInt();
        System.out.println("age = " + age);

        System.out.println("请输入您的体重：");
        double weight = scanner.nextDouble();
        System.out.println("weight = " + weight);

        System.out.println("请输入您的单身状况（true / false）：");
        boolean singleStatus = scanner.nextBoolean();
        System.out.println("singleStatus = " + singleStatus);

        // 对于 char 型变量的获取，`Scanner` 没有提供相关的方法，只能获取一个字符串
        System.out.println("请输入您的性别：");
        String gender = scanner.next();
        char genderChar = gender.charAt(0);
        System.out.println("genderChar = " + genderChar);
    }
}
