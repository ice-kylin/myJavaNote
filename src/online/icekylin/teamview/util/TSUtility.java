package online.icekylin.teamview.util;

import java.util.Scanner;

public class TSUtility {
    private static final Scanner scanner = new Scanner(System.in);

    private static String readString(String[] choices, String msg, String errorMsg) {
        boolean correctness = false;
        String userChoice;

        System.out.print(msg);

        do {
            userChoice = scanner.nextLine();

            for (String choice : choices) {
                if (choice.equals(userChoice)) {
                    correctness = true;

                    break;
                }
            }

            System.out.print(errorMsg);
        } while (!correctness);

        return userChoice;
    }

    private static int readInt(int min, int max, String msg, String errorMsg) {
        int userChoice;

        System.out.print(msg);

        do {
            try {
                userChoice = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.print(errorMsg);
                continue;
            }

            if (userChoice >= min && userChoice <= max) {
                break;
            } else {
                System.out.print(errorMsg);
            }
        } while (true);

        return userChoice;
    }

    public static String readMenuSelection() {
        return readString(new String[]{"1", "2", "3", "4"}, "请输入选项 (1-4)：", "选择错误，请重新输入 (1-4)：");
    }

    public static void readReturn() {
        System.out.println("按下回车继续...");
        scanner.nextLine();
    }
}
