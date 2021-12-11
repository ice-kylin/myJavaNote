package array.exer;

/*
# 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{43, 32, 76, -98, 0, 64, 33, -21, 32, 99};
        int tmp;

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[j - 1]) {
                    tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        for (int num : nums) {
            System.out.printf("%2d  ", num);
        }
    }
}
