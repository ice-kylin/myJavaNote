package array;

import java.util.Arrays;

/*
# `java.util.Arrays`

- 操作数组的工具类
- 常用方法
  - `Arrays.equals()`
  - `Arrays.toString()`
  - `Arrays.fill()`
  - `Arrays.sort()`
  - `Arrays.binarySearch()`
 */
public class ArraysOverview {
    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{1, 3, 2, 4};

        boolean isEqual = Arrays.equals(arr1, arr2);
        System.out.println("isEqual = " + isEqual);

        System.out.println(Arrays.toString(arr1));

        Arrays.fill(arr1, 10);
        System.out.println(Arrays.toString(arr1));

        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));

        int index = Arrays.binarySearch(arr2, 2);
        System.out.println(index);
    }
}
