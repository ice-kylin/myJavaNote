package objectoriented;

/*
# 自定义 Array 工具类
 */
public class ArrayUtilTest {
    public static void main(String[] args) {
        ArrayUtil au = new ArrayUtil();
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = (int) (Math.random() * 11);
        }

        System.out.println(au.traverseArray(arr));

        System.out.println("au.getMax(arr) = " + au.getMax(arr));

        System.out.println("au.getMin(arr) = " + au.getMin(arr));

        System.out.println("au.getSum(arr) = " + au.getSum(arr));

        au.reverseArray(arr);
        System.out.println(au.traverseArray(arr));

        int[] arr2 = au.copyArray(arr);
        System.out.println(au.traverseArray(arr2));

        au.sortArray(arr);
        System.out.println(au.traverseArray(arr));

        System.out.println(au.searchItem(arr, arr[5]));
    }
}

class ArrayUtil {
    // 求数组的最大值
    public int getMax(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    // 求数组的最小值
    public int getMin(int[] arr) {
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    // 求数组的总和
    public int getSum(int[] arr) {
        int sum = 0;

        for (int j : arr) {
            sum += j;
        }

        return sum;
    }

    // 反转数组
    public void reverseArray(int[] arr) {
        int tmp;
        int arrayLength = arr.length;

        for (int i = 0; i < arrayLength / 2; i++) {
            tmp = arr[i];
            arr[i] = arr[arrayLength - 1 - i];
            arr[arrayLength - 1 - i] = tmp;
        }
    }

    // 复制数组
    public int[] copyArray(int[] arr) {
        int[] copy = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }

        return copy;
    }

    // 数组排序
    public void sortArray(int[] arr) {
        int tmp;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }
            }
        }
    }

    // 遍历数组
    public String traverseArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append(", ");
        }

        sb.append(arr[arr.length - 1]).append("]");

        return sb.toString();
    }

    // 查找元素
    public int searchItem(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
