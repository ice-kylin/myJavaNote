package processcontrol;

/*
# 嵌套循环

- 将一个循环结构声明在另一个循环结构的循环体中，就构成了嵌套循环
- 概念
  - 外层循环
  - 内层循环

## 说明

- 内层循环结构遍历一遍，只相当于外层循环循环体执行了一次
- 假设外层循环需要执行 m 次，内层循环需要执行 n 次，此时内层循环的循环体一共执行了 m * n 次

## 技巧

- 外层循环控制行数
- 内层循环控制列数
 */
public class NestedLoop {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5 - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j < i; j++) {
                System.out.print("* ");
            }

            System.out.println("*");
        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j < 5 - i; j++) {
                System.out.print("* ");
            }

            System.out.println("*");
        }
    }
}
