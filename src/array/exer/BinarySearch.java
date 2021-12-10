package array.exer;

/*
# 二分查找

- 前提：所要查找的数组必须有序
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-98, -34, 2, 34, 54, 66, 79, 105, 210, 333};
        int dest1 = -34;
        int dest2 = 233;

        int startIndex = 0;
        int endIndex = nums.length - 1;
        boolean found = false;

        while (startIndex <= endIndex) {
            if (nums[(endIndex - startIndex) / 2 + startIndex] > dest2) {
                endIndex = (endIndex - startIndex) / 2 + startIndex - 1;
            } else if (nums[(endIndex - startIndex) / 2 + startIndex] < dest2) {
                startIndex = (endIndex - startIndex) / 2 + startIndex + 1;
            } else {
                System.out.println("找到了，位置为：" + (endIndex - startIndex) / 2);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("没找到");
        }
    }
}
