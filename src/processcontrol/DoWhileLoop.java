package processcontrol;

/*
# `do - while` 循环

## 4 个要素

1. 初始化条件
2. 循环条件（boolean 类型）
3. 循环体
4. 迭代条件

## `do - while` 循环的结构

1;
do {
3;
4;
} while (2);

## 说明

- `do - while` 循环至少会执行一次循环体
- 开发中使用 `for` 和 `while` 循环更多一些
 */

public class DoWhileLoop {
    public static void main(String[] args) {
        int i = 1;
        int sumOfEven = 0;
        int countOfEven = 0;

        do {
            if (i % 2 == 0) {
                System.out.println(i);
                sumOfEven += i;
                countOfEven++;
            }

            i++;
        } while (i <= 100);

        System.out.println("100 以内的偶数和为：" + sumOfEven);
        System.out.println("100 以内的偶数共有：" + countOfEven);
    }
}
