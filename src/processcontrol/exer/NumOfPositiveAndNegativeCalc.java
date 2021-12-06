package processcontrol.exer;
/*
# 说明

- 不在循环条件部分限制次数的结构：
  - `while (true)`
  - `for (; ; )`
- 结束循环的方式
  - 循环条件部分返回 `false`
  - 在循环体中执行 `break`
 */

import java.util.Scanner;

public class NumOfPositiveAndNegativeCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNum;
        int countOfPositiveNum = 0;
        int countOfNegativeNum = 0;

        /*
        while (true) {
            System.out.println("请输入一个整数：");
            inputNum = scanner.nextInt();

            if (inputNum == 0) {
                break;
            } else if (inputNum < 0) {
                countOfNegativeNum++;
            } else {
                countOfPositiveNum++;
            }
        }
        */

        for (; ; ) {
            System.out.println("请输入一个整数：");
            inputNum = scanner.nextInt();

            if (inputNum == 0) {
                break;
            } else if (inputNum < 0) {
                countOfNegativeNum++;
            } else {
                countOfPositiveNum++;
            }
        }

        System.out.println("输入的负数共有：" + countOfNegativeNum);
        System.out.println("输入的正数共有：" + countOfPositiveNum);
    }
}
