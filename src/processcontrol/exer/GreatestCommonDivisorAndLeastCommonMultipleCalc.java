package processcontrol.exer;

import java.util.Scanner;

public class GreatestCommonDivisorAndLeastCommonMultipleCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int biggerNum, smallerNum, greatestCommonDivisor, leastCommonMultiple;

        System.out.println("请输入第一个整数：");
        int num1 = sc.nextInt();

        System.out.println("请输入第二个整数：");
        int num2 = sc.nextInt();

        // 计算大小
        if (num1 > num2) {
            biggerNum = num1;
            smallerNum = num2;
        } else {
            biggerNum = num2;
            smallerNum = num1;
        }

        for (int i1 = smallerNum; true; i1--) {
            if (smallerNum % i1 == 0 && biggerNum % i1 == 0) {
                greatestCommonDivisor = i1;
                break;
            }
        }

        for (int i2 = biggerNum; true; i2++) {
            if (i2 % smallerNum == 0 && i2 % biggerNum == 0) {
                leastCommonMultiple = i2;
                break;
            }
        }

        System.out.println(num1 + " 和 " + num2 + " 的最大公约数是 " + greatestCommonDivisor);
        System.out.println("最小公倍数是 " + leastCommonMultiple);
    }
}
