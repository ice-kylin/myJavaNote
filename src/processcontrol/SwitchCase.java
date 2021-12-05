package processcontrol;
/*
# `switch - case` 结构

- 格式
    ```java
    switch (条件表达式) {
        case 常量1:
            执行语句1;
            break;
        case 常量2:
            执行语句2;
            break;
        default:
            执行语句n;
    }
    ```
- 说明
  1. 根据 `switch` 表达式中的值依次匹配各个 `case` 中的常量
    - 一旦匹配成功，则进入相应的 `case` 结构中调用其执行语句
    - 当调用完执行语句之后，则仍然继续向下执行其它 `case` 结构中的执行语句
    - 直到遇到 `break` 关键字或到 `switch - case` 末尾结束为止
  2. `break` 关键字可以使用在 `switch - case` 结构中
    - 表示一旦执行到此关键字，就跳出
    - 可选的
  3. `switch` 结构中的表达式，只能是如下的 6 种数据类型之一：
    1. byte
    2. short
    3. char
    4. int
    5. 枚举类型
    6. String 类型
  4. `case` 后面只能声明常量，不能声明范围
  5. `default` 相当于 `if - else` 中的 `else`
    - 可选的
    - 可以放到前面（一般不会这么做）
  6. `switch - case` 和 `if - else` 的说明
    - 凡是可以使用 `switch - case` 的结构，都可以转换为 `if - else`
      - 反之，不成立
    - 我们写分支结构时，当发现既可以使用 `switch - case`，又可以使用 `if - else` 时（，同时 `switch` 中表达式的取值情况不太多）
      - 优先使用 `switch - case`
 */

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();

        switch (num1) {
            case 0:
                System.out.println("零");
            case 1:
                System.out.println("一");
            case 2:
                System.out.println("二");
            case 3:
                System.out.println("三");
                break;
            default:
                System.out.println("其它");
        }
    }
}
