package operator;

/*
# 位运算符

- 位运算是直接对整数的二进制进行的运算

- `<<`
  - 左移
  - 空位补 1，被移除的最高位丢弃
  - 在一定范围内，每向左移 1 位，相当于 `* 2`
- `>>`
  - 右移
  - 被移位的二进制最高位是 0，右移后空缺位补 0；最高位是 1，空缺位补 1
  - 在一定范围内，每向右移 1 位，相当于 `/ 2`
- `>>>`
  - 无符号右移
  - 被移位二进制最高位无论是 0 或者 1，空缺位都用 0 补
- `&`
  - 与运算
  - 只有 `1 & 1` 时结果是 1，否则是 0
- `|`
  - 或运算
  - 只有 `0 | 0` 时结果是 0，否则是 1
- `^`
  - 异或运算
  - 相同二进制位进行 `^` 运算，结果是 0
  - 不同二进制位进行 `^` 运算，结果是 1
- `~`
  - 取反运算
  - 正数取反，各二进制码按补码各位取反
  - 负数取反，各二进制码按补码各位取反
 */
public class BitOperator {
    public static void main(String[] args) {
        int i1 = 10;
        i1 = i1 << 2; // 40
        System.out.println("i1 = " + i1);

        // 交换两个变量的值
        // 定义临时变量
        int n1 = 10;
        int n2 = 20;
        int temp;
        System.out.println("n1 = " + n1 + ", n2 = " + n2);

        temp = n1;
        n1 = n2;
        n2 = temp;
        System.out.println("n1 = " + n1 + ", n2 = " + n2);

        // 不用定义临时变量
        // 相加操作可能超出存储范围
        // 有局限性 —— 只能适用于数值类型
        n1 = n1 + n2;
        n2 = n1 - n2;
        n1 = n1 - n2;
        System.out.println("n1 = " + n1 + ", n2 = " + n2);

        // 使用位运算符
        // m = (m ^ n) ^ n
        n1 = n1 ^ n2;
        n2 = n1 ^ n2;
        n1 = n1 ^ n2;
        System.out.println("n1 = " + n1 + ", n2 = " + n2);
    }
}
