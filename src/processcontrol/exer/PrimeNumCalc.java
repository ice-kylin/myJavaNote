package processcontrol.exer;
/*
# 质数

只能被 `1` 和它本身整除的自然数
 */

import java.util.Scanner;

public class PrimeNumCalc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入要计算多少以内的质数：");
        int maxNum = scanner.nextInt();
        boolean flag;

        for (int i = 1; i < maxNum; i++) {
            flag = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println(i);
            }
        }
    }
}
