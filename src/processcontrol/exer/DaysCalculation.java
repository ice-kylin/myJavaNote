package processcontrol.exer;
/*
## 说明

- `break` 在 `switch - case` 中是可选的
 */

import java.util.Scanner;

public class DaysCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfDaysInFebruary;
        int numOfDays = 0;

        System.out.println("请输入年份：");
        int year = scanner.nextInt();

        System.out.println("请输入月份：");
        int month = scanner.nextInt();

        System.out.println("请输入日期：");
        int day = scanner.nextInt();

        // 判断是否为闰年
        if (year % 100 == 0) {
            if (year % 400 == 0) {
                numOfDaysInFebruary = 29;
            } else {
                numOfDaysInFebruary = 28;
            }
        } else {
            if (year % 4 == 0) {
                numOfDaysInFebruary = 29;
            } else {
                numOfDaysInFebruary = 28;
            }
        }

        // 计算天数
        switch (month) {
            case 12:
                numOfDays += 30;
            case 11:
                numOfDays += 31;
            case 10:
                numOfDays += 30;
            case 9:
                numOfDays += 31;
            case 8:
                numOfDays += 31;
            case 7:
                numOfDays += 30;
            case 6:
                numOfDays += 31;
            case 5:
                numOfDays += 30;
            case 4:
                numOfDays += 31;
            case 3:
                numOfDays += numOfDaysInFebruary;
            case 2:
                numOfDays += 31;
            case 1:
                numOfDays += day;
        }

        if (numOfDays != 0) {
            System.out.println("这一天为 " + year + " 年的第 " + numOfDays + " 天！");
        } else {
            System.out.println("输入有误！");
        }
    }
}
