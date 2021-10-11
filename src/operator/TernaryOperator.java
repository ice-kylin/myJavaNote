package operator;

/*
# 三元运算符

- 格式 —— `(条件表达式) ? 表达式1 : 表达式2;`
- `条件表达式` 的结果为 boolean 类型
- 根据条件表达式真或假，决定执行 `表达式1` 还是 `表达式2`
  - 如果 `条件表达式` 的结果为 `true`，则执行 `表达式1`
  - 如果 `条件表达式` 的结果为 `false`，则执行 `表达式2`
 */
public class TernaryOperator {
    public static void main(String[] args) {
        // 获取两个整数的较大值
        int i1 = 10;
        int i2 = 20;
        int rst = i1 >= i2 ? i1 : i2;
        System.out.println("rst = " + rst);
    }
}
