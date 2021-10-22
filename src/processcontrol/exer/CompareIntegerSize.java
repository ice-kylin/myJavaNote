package processcontrol.exer;
/*
## 说明

- `if - else` 结构是可以嵌套使用的
- 如果 `if - else` 结构中的执行语句只有一行时，对应的一对 `{}` 可以省略
  - 但是不建议省略
 */

import java.util.Scanner;

public class CompareIntegerSize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入第一个整数：");
        int num1 = scanner.nextInt();
        System.out.println("请输入第二个整数：");
        int num2 = scanner.nextInt();
        System.out.println("请输入第三个整数：");
        int num3 = scanner.nextInt();

        int maxNum, minNum, middleNum;

        if (num1 > num2) {
            if (num3 > num1) {
                maxNum = num3;
                middleNum = num1;
                minNum = num2;
            } else if (num3 < num2) {
                maxNum = num1;
                middleNum = num2;
                minNum = num3;
            } else {
                maxNum = num1;
                middleNum = num3;
                minNum = num2;
            }
        } else {
            if (num3 > num2) {
                maxNum = num3;
                middleNum = num2;
                minNum = num1;
            } else if (num3 < num1) {
                maxNum = num2;
                middleNum = num1;
                minNum = num3;
            } else {
                maxNum = num2;
                middleNum = num3;
                minNum = num1;
            }
        }

        System.out.println("最小的数是：" + minNum);
        System.out.println("之间的数是：" + middleNum);
        System.out.println("最大的数是：" + maxNum);
    }
}
