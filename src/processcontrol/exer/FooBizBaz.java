package processcontrol.exer;

import java.util.Scanner;

public class FooBizBaz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入需要遍历的最大值：");
        int maxNum = sc.nextInt();
        String outputString;

        for (int i = 1; i <= maxNum; i++) {
            outputString = "" + i;

            if (i % 3 == 0) {
                outputString += " foo";
            }
            if (i % 5 == 0) {
                outputString += " biz";
            }
            if (i % 7 == 0) {
                outputString += " baz";
            }

            System.out.println(outputString);
        }
    }
}
