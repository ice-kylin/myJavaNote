package processcontrol;

/*
# `while` 循环

## 4 个要素

1. 初始化条件
2. 循环条件（boolean 类型）
3. 循环体
4. 迭代条件

## `while` 循环的结构

1;
while (2) {
    3;
    4;
}

## 说明

- 小心不要丢了迭代条件
- 一旦丢了，就可能导致死循环
- `for` 循环和 `while` 循环是可以相互转换的
  - 区别：`for` 循环和 `while` 循环的初始化条件部分的作用范围不同
 */
public class WhileLoop {

    public static void main(String[] args) {
        int i = 1;
        while (i <= 100) {
            if (i % 2 == 0) {
                System.out.println(i);
            }

            i++;
        }
    }
}
