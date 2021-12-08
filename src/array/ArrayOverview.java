package array;

/*
 * # 数组
 *
 * - 数组（Array），是多个相同类型数据按一定顺序排列的集合，并使用一个名字命名
 * - 通过编号的方式对这些数据进行统一管理
 *
 * ## 数组相关概念
 *
 * - 数组名
 * - 元素
 * - 角标 / 下标 / 索引
 * - 数组的长度（元素的个数）
 *
 * ## 数组的特点
 *
 * - 数组是有序排列的
 * - 数组是引用数据类型
 * - 数组的元素既可以是引用数据类型，也可以是基本数据类型
 * - 创建数组对象会在内存中开辟一整块连续的空间
 * - 数组的长度一旦确定，就不能修改
 *
 * ## 数组的分类
 *
 * 1. 按照维数
 *   - 一维数组
 *   - 二维数组
 *   - ...
 * 2. 按照数组元素的类型
 *   - 基本数据类型元素的数组
 *   - 引用数据类型元素的数组
 *
 * # 一维数组
 *
 * ## 一维数组的声明和初始化
 *
 * - 静态初始化：数组的初始化和数组元素的赋值操作同时进行
 * - 动态初始化：数组的初始化和数组元素的赋值操作分开进行
 * - 数组一旦初始化完成，其长度就确定了
 *
 * ## 调用数组指定位置的元素
 *
 * - 通过索引的方式调用
 * - 数组的索引从 `0` 开始，到 `数组的长度 - 1` 结束
 *
 * ## 数组的长度与遍历数组
 *
 * - `.length` 属性
 *
 * ## 数组元素的默认初始化值
 *
 * - 数组元素是整型
 *   - `0`
 * - 数组元素是浮点型
 *   - `0.0`
 * - 数组元素是 char 型
 *   - `0`
 * - 数组元素是 boolean 型
 *   - `false`
 * - 数组元素是引用数据类型
 *
 *
 * ## 数组的内存解析
 *
 * - 内存的简化结构
 *   - 栈（stack）
 *     - 局部变量
 *   - 堆（heap）
 *     - `new` 出来的结构
 *       - 对象
 *       - 数组
 *   - 方法区
 *     - 常量池
 *     - 静态域
 */
public class ArrayOverview {

    public static void main(String[] args) {
        int[] ids;
        ids = new int[]{1, 2, 3, 4}; // 静态初始化

        int[] arr0 = {1, 2, 3}; // 类型推断

        String[] names = new String[5]; // 动态初始化

        names[0] = "Issac";
        names[1] = "icekylin";
        names[2] = "Acker";
        names[3] = "Dyp";
        names[4] = "Eyu";

        System.out.println("names.length = " + names.length);
        System.out.println("ids.length = " + ids.length);

        System.out.println();

        for (int i = 0; i < names.length; i++) {
            System.out.println("names[" + i + "] = " + names[i]);
        }

        System.out.println();

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }

        System.out.println();

        short[] arr1 = new short[5];

        for (int i = 0; i < arr1.length; i++) {
            System.out.println("arr1[" + i + "] = " + arr1[i]);
        }

        System.out.println();

        double[] arr2 = new double[5];

        for (int i = 0; i < arr2.length; i++) {
            System.out.println("arr2[" + i + "] = " + arr2[i]);
        }

        System.out.println();

        char[] arr3 = new char[5];

        for (int i = 0; i < arr3.length; i++) {
            System.out.println("arr3[" + i + "] = " + arr3[i]);
        }

        System.out.println();

        boolean[] arr4 = new boolean[5];

        for (int i = 0; i < arr4.length; i++) {
            System.out.println("arr3[" + i + "] = " + arr4[i]);
        }

        System.out.println();

        String[] arr5 = new String[5];

        for (int i = 0; i < arr5.length; i++) {
            System.out.println("arr5[" + i + "] = " + arr5[i]);
        }
    }

}
