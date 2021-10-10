package operator;

/*
# 算术运算符

- `+`
  - 正号
- `-`
  - 符号
- `+`
  - 加
- `-`
  - 减
- `*`
  - 乘
- `/`
  - 除
- `%`
  - 取模（取余）
  - 结果的正负与被模数的正负相同
  - 开发中经常使用 `%` 判断是否能除尽
- `++`
  - 自增
    - 前：先运算后取值
    - 后：先取值后运算
  - 不会改变变量的数据类型
- `--`
  - 自减
    - 前：先运算后取值
    - 后：先取值后运算
  - 不会改变变量的数据类型
- `+`
  - 字符串连接
 */
public class ArithmeticOperator {
    public static void main(String[] args) {
        // `/`
        int i1 = 12;
        int i2 = 5;
        int rst1 = i1 / i2; // 2
        System.out.println("rst1 = " + rst1);

        int rst2 = i1 / i2 * i2; // 10
        System.out.println("rst2 = " + rst2);

        double rst3 = (double) i1 / i2; // 2.4
        System.out.println("rst3 = " + rst3);

        // `%`
        int i3 = -12;
        int i4 = 5;
        System.out.println("i3 % i4 = " + i3 % i4);

        // ++
        int a1 = 10;
        int b1 = ++a1;
        System.out.println("a1 = " + a1 + ", b1 = " + b1); // a1 = 11, b1 = 11

        int a2 = 10;
        int b2 = a2++;
        System.out.println("a2 = " + a2 + ", b2 = " + b2); // a1 = 11, b1 = 10

        // --
        int a3 = 10;
        int b3 = --a3;
        System.out.println("a3 = " + a3 + ", b3 = " + b3); // a3 = 9, b3 = 9

        int a4 = 10;
        int b4 = a4--;
        System.out.println("a4 = " + a4 + ", b4 = " + b4); // a4 = 9, b4 = 10

        byte s1 = 127;
        s1++; // -128
        System.out.println("s1 = " + s1);
    }
}
