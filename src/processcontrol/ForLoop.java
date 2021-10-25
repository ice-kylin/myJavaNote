package processcontrol;

/*
# `for` 循环

## 4 个要素

1. 初始化条件
2. 循环条件（boolean 类型）
3. 循环体
4. 迭代条件

## `for` 循环的结构

for (1; 2; 4) {
    3;
}
 */
public class ForLoop {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i);
        }

        int i = 0;
        for (System.out.println("\na"); i < 5; System.out.println("c"), i++) {
            System.out.println("b");
        }

        // 遍历 100 以内的偶数、所有偶数的和以及偶数的个数
        int sumOfEven = 0;
        int countOfEven = 0;

        System.out.println("100 以内的偶数有：");

        for (i = 1; i <= 100; i++) {
            if (i % 2 == 0 && i != 100) {
                sumOfEven += i;
                countOfEven++;
                System.out.printf("%d, ", i);
            } else if (i == 100) {
                sumOfEven += i;
                countOfEven++;
                System.out.printf("%d%n", i);
            }
        }

        System.out.println("100 以内偶数的和为：" + sumOfEven);
        System.out.println("100 以内偶数的个数为：" + countOfEven);
    }
}
