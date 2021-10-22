package processcontrol.exer;

import java.util.Scanner;

public class ConvertCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入一个小写英文字母：");
        String lowercaseLetter = scanner.next();

        char lowercaseLetterChar = lowercaseLetter.charAt(0);

        switch (lowercaseLetterChar) {
            case 'a':
                System.out.println("A");
                break;
            case 'b':
                System.out.println("B");
                break;
            case 'c':
                System.out.println("C");
                break;
            case 'd':
                System.out.println("D");
                break;
            case 'e':
                System.out.println("E");
                break;
            default:
                System.out.println("Other");
        }
    }
}
