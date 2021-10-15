package operator;

/*
# 三元运算符

- 格式 —— `(条件表达式) ? 表达式1 : 表达式2;`
- `条件表达式` 的结果为 boolean 类型
- 根据条件表达式真或假，决定执行 `表达式1` 还是 `表达式2`
  - 如果 `条件表达式` 的结果为 `true`，则执行 `表达式1`
  - 如果 `条件表达式` 的结果为 `false`，则执行 `表达式2`
- `表达式1` 和 `表达式2` 要求是一致的（可以统一为同一类型）
- 三元运算符可以嵌套使用
- 凡是可以使用三元运算符的地方，都可以改写为 `if - else`
  - 反之，不成立
- 如果程序既可以使用三元运算符，又可以使用 `if - else` 结构，那么优先选择三元运算符
  - 原因：简洁、执行效率高
 */
public class TernaryOperator {
    public static void main(String[] args) {
        // 获取两个整数的较大值
        int i1 = 10;
        int i2 = 20;
        int rst1 = i1 >= i2 ? i1 : i2;
        System.out.println("rst1 = " + rst1);

        // 嵌套
        String maxStr = i1 > i2 ? "i1 大" : (i1 == i2 ? "i1 和 i2 一样大" : "i2 大");
        System.out.println("maxStr = " + maxStr);

        // 获取 3 个数的最大值
        int i3 = 25;
        int rst2 = i1 > i2 ? (i1 > i3 ? i1 : i3) : (i2 > i3 ? i2 : i3);
        System.out.println("rst2 = " + rst2);
    }
}
