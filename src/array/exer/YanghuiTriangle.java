package array.exer;

import java.util.Scanner;

public class YanghuiTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入行数：");
        int rowNum = scanner.nextInt();
        int[][] yanghuiTriangle = new int[rowNum][];

        for (int i = 0; i < yanghuiTriangle.length; i++) {
            yanghuiTriangle[i] = new int[i];

            for (int j = 0; j < yanghuiTriangle[i].length; j++) {
                if (j == 0 || j == yanghuiTriangle[i].length - 1) {
                    yanghuiTriangle[i][j] = 1;
                } else {
                    yanghuiTriangle[i][j] = yanghuiTriangle[i - 1][j - 1] + yanghuiTriangle[i - 1][j];
                }

                System.out.print(yanghuiTriangle[i][j] + " ");
            }

            System.out.println();
        }
    }
}
