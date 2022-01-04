package online.icekylin.teamview.util;

import java.util.Scanner;

public class TSUtility {
    private static final Scanner scanner = new Scanner(System.in);

    private static String readString(String[] choices, String msg, String errorMsg) {
        boolean correctness = false;
        String userChoice;

        System.out.println(msg);

        do {
            userChoice = scanner.nextLine();

            for (String choice : choices) {
                if (choice.equals(userChoice)) {
                    correctness = true;
                    break;
                }
            }

            System.out.println(errorMsg);
        } while (!correctness);

        return userChoice;
    }
}
