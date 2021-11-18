package processcontrol.exer;

import java.util.Scanner;

public class NumberOfDaffodilsCalc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要计算的最大数：");
        int maxNum = sc.nextInt();
        int numOfDigits, sumOfDigits;

        for (int i1 = 0; i1 <= maxNum; i1++) {
            // 判断位数
            numOfDigits = 1;
            while (i1 % Math.pow(10, numOfDigits) != i1) {
                numOfDigits++;
            }

            // 求和
            sumOfDigits = 0;
            for (int i2 = 1; i2 <= numOfDigits; i2++) {
                sumOfDigits += Math.pow((int) ((i1 % Math.pow(10, i2)) / (int) Math.pow(10, i2 - 1)), numOfDigits);
            }
            if (sumOfDigits == i1) {
                System.out.println(i1);
            }
        }
    }
}
