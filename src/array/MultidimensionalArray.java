package array;

/*
# 二维数组

- 可以看成是一维数组又作为另一个一维数组的元素存在
- 实际上从数组底层的运行机制来看没有多维数组

## 说明

- 二维数组的声明和初始化
- 调用数组指定位置的元素
- 数组的长度与遍历数组
- 数组元素的默认初始化值
  - 初始化方式 1
    - 外层数组的元素
      - 地址值
    - 内层数组的元素
      - 与一维数组初始化情况相同
  - 初始化方式 2
    - 外层数组的元素
      - null
    - 内层数组的元素
      - 不能调用，否则报错
- 数组的内存解析
 */
public class MultidimensionalArray {
    public static void main(String[] args) {
        int[][] arr1 = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}}; // 静态初始化

        String[][] arr2 = new String[3][2]; // 动态初始化 1

        String[][] arr3 = new String[3][]; // 动态初始化 2

        int[][] arr4 = new int[][]{null, null, null};

        System.out.println(arr1[0][1]); // 2

        for (int[] ints : arr1) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        System.out.println();

        System.out.println("arr2 = " + arr2);
        System.out.println("arr2[0] = " + arr2[0]);
        System.out.println("arr2[0][0] = " + arr2[0][0]);

        System.out.println();

        System.out.println("arr3 = " + arr3);
        System.out.println("arr3[0] = " + arr3[0]);
    }
}
