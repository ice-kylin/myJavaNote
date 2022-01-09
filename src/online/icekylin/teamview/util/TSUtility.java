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

            if (!correctness) {
                System.out.print(errorMsg);
            }
        } while (!correctness);

        return userChoice;
    }

    public static int readInt(String msg, String errorMsg) {
        int userChoice;

        System.out.print(msg);

        do {
            try {
                userChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.print(errorMsg);
                continue;
            }

            break;
        } while (true);

        return userChoice;
    }

    public static String readMenuSelection() {
        return readString(new String[]{"1", "2", "3", "4"},
                "1) 团队列表\n2) 添加团队成员\n3) 删除团队成员\n4) 退出\n请输入选项 (1 - 4)：",
                "选择错误，请重新输入 (1 - 4)："
        );
    }

    public static void readReturn() {
        System.out.print("按下回车继续...");
        scanner.nextLine();
    }

    public static boolean readConfirmSelection(String msg, String errorMsg) {
        String selection = readString(new String[]{"Y", "y", "N", "n"}, msg, errorMsg);

        switch (selection) {
            case "Y":
            case "y":
                return true;
            case "N":
            case "n":
            default:
                return false;
        }
    }
}
