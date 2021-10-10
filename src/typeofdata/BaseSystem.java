package typeofdata;

/*
# 不同进制的表示方式

*世界上有 10 种人 —— 认识二进制的和不认识二进制的。*

- 二进制（binary）
  - 0、1
  - 以 `0b` 或 `0B` 开头
- 十进制（decimal）
  - 0 ~ 9
- 八进制（octal）
  - 0 ~ 7
  - 以数字 `0` 开头
- 十六进制（hex）
  - 0 ~ 9 及 A ~ F
  - 以 `0x`或 `0X` 开头

## 进制转换

### 二进制 <-> 八进制

3 个二进制位 <-> 1 个八进制位

### 二进制 <-> 十六进制

4 个二进制位 <-> 1 个十六进制位
 */
public class BaseSystem {
    public static void main(String[] args) {
        int i1 = 0b10;
        int i2 = 10;
        int i3 = 07;
        int i4 = 0xF;

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
        System.out.println("i4 = " + i4);
    }
}
