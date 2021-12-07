package processcontrol.exer.bookkeeping;

import java.util.Scanner;

public class Utility {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printMainMenu() {
        System.out.println("-------- 💰 家庭收支记账软件 💸 --------");
        System.out.println("1) 收支明细");
        System.out.println("2) 登记收入");
        System.out.println("3) 登记支出");
        System.out.println("4) 退出程序");
        System.out.println("----------------->8------------------");
    }

    public static String readMenuSelection() {
        String selection;

        while (true) {
            selection = scanner.next();
            switch (selection) {
                case "1":
                case "2":
                case "3":
                case "4":
                    return selection;
                default:
                    System.out.print("选择错误，请重新输入：");
            }
        }
    }

    public static double readNum() {
        double inputNum;

        while (true) {
            inputNum = scanner.nextDouble();

            if (inputNum >= -10000 || inputNum <= 10000) {
                return inputNum;
            }

            System.out.print("金额输入错误，请重新输入：");
        }
    }

    public static String readString() {
        return scanner.next();
    }

    public static boolean readConfirmSelection() {
        while (true) {
            switch (scanner.next()) {
                case "Y":
                case "y":
                    return true;
                case "N":
                case "n":
                    return false;
                default:
                    System.out.print("选择错误，请重新选择：");
            }
        }
    }
}
