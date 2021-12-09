package array.exer;

import java.util.Scanner;

public class RandomAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入数组长度（小于 30）：");
        int[] arr = new int[scanner.nextInt()];

        label:
        for (int i = 0; i < arr.length; ) {

            arr[i] = (int) (Math.random() * 30);

            if (arr[i] == 0) {
                continue;
            }

            for (int j = 0; j < i; j++) {
                if (arr[j] == arr[i]) {
                    continue label;
                }
            }

            i++;
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
