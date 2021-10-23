package processcontrol.exer;

import java.util.Scanner;

public class ZodiacCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String zodiac = "";

        System.out.println("请输入年份：");
        int year = scanner.nextInt();

        switch (year % 12) {
            case 0:
                zodiac = "猴 - 申（Monkey）";
                break;
            case 1:
                zodiac = "鸡 - 酉（Rooster）";
                break;
            case 2:
                zodiac = "狗 - 戌（Dog）";
                break;
            case 3:
                zodiac = "猪 - 亥（Pig）";
                break;
            case 4:
                zodiac = "鼠 - 子（Rat）";
                break;
            case 5:
                zodiac = "牛 - 丑（Ox）";
                break;
            case 6:
                zodiac = "虎 - 寅（Tiger）";
                break;
            case 7:
                zodiac = "兔 - 卯（Rabbit）";
                break;
            case 8:
                zodiac = "龙 - 辰（Dragon）";
                break;
            case 9:
                zodiac = "蛇 - 巳（Snake）";
                break;
            case 10:
                zodiac = "马 - 午（Horse）";
                break;
            case 11:
                zodiac = "羊 - 未（Goat）";
        }

        System.out.println(year + " 年的生肖是 " + zodiac + "!");
    }
}
