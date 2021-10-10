package operator;

/*
# 逻辑运算符

- `&`
  - 逻辑与
- `&&`
  - 短路与
- `|`
  - 逻辑或
- `||`
  - 短路或
- `!`
  - 逻辑非
- `^`
  - 逻辑异或

- `&` 和 `&&`
  - `&` 和 `&&` 的运算结果相同
  - 当符号左边是 `true` 时，二者都会执行符号右边的运算
  - 当符号左边时 `false` 时，`&` 继续执行符号右边的运算、`&&` 不再执行符号右边的运算
- `|` 和 `||`
  - `|` 和 `||` 的运算结果相同
  - 当符号左边是 `false` 时，二者都会执行符号右边的运算
  - 当符号左边时 `true` 时，`|` 继续执行符号右边的运算、`||` 不再执行符号右边的运算
- 开发中推荐使用 `&&` 和 `||`
 */
public class LogicalOperator {
    public static void main(String[] args) {
        boolean b1 = true;
        boolean b2 = false;
        int i1 = 10;
        int i2 = 10;

        // &
        if (b2 & (i1++ >= 10)) {
            System.out.println("b2 & (i1++ >= 10) = true");
        } else {
            System.out.println("b2 & (i1++ >= 10) = false");
        }
        System.out.println("i1 = " + i1);

        // &&
        if (b2 && (i2++ >= 10)) {
            System.out.println("b2 & (i1++ >= 10) = true");
        } else {
            System.out.println("b2 & (i1++ >= 10) = false");
        }
        System.out.println("i2 = " + i2);

        int i3 = 10;
        int i4 = 10;

        // |
        if (b1 | (i3++ >= 10)) {
            System.out.println("b1 | (i3++ >= 10) = true");
        } else {
            System.out.println("b1 | (i3++ >= 10) = false");
        }
        System.out.println("i3 = " + i3);

        // ||
        if (b1 || (i4++ >= 10)) {
            System.out.println("b1 || (i4++ >= 10) = true");
        } else {
            System.out.println("b1 || (i4++ >= 10) = false");
        }
        System.out.println("i4 = " + i4);
    }
}
