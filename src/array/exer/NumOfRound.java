package array.exer;

import java.util.Scanner;

public class NumOfRound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入数组长度：");
        int[] nums = new int[scanner.nextInt()];
        int sumOfNums = 0;
        int maxOfNums = 10;
        int minOfNums = 99;
        double avgOfNums;

        System.out.print("\n数组为：");

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 89) + 10;
            System.out.printf("%2d ", nums[i]);

            sumOfNums += nums[i];

            if (nums[i] > maxOfNums) {
                maxOfNums = nums[i];
            }

            if (nums[i] < minOfNums) {
                minOfNums = nums[i];
            }
        }

        avgOfNums = ((double) sumOfNums) / nums.length;

        System.out.println("\n最大值为：" + maxOfNums);
        System.out.println("最小值为：" + minOfNums);
        System.out.println("和为：" + sumOfNums);
        System.out.println("平均值为：" + avgOfNums);
    }
}
