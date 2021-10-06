package typeofdata;

/*
# 整型变量

- byte
  - 占用储存空间：1 字节 = 8 bit 位
  - 表数范围：-128 ~ 127
- short
  - 占用储存空间：2 字节
  - 表数范围：-2^15 ~ 2^15 - 1
- int
  - 占用储存空间：4 字节
  - 表数范围：-2^31 ~ 2^31 - 1
  - 通常定义整型变量时使用 int 型
- long
  - 8 字节
  - -2^63 ~ 2^63 -1
  - 声明 long 型变量，必须以 `l` 或 `L` 结尾
 */
public class IntegerVariable {
    public static void main(String[] args) {
        // byte
        byte b1 = -128;
        byte b2 = 12;

        System.out.println(b1);
        System.out.println(b2);

        // short
        short s1 = 128;
        // int
        int i1 = 2048;
        // long
        long l1 = 23333333333L;

        System.out.println(s1);
        System.out.println(i1);
        System.out.println(l1);
    }
}
