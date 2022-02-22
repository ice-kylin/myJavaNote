package typeofdata;

import org.junit.Test;

/*
# 类型转换

## 自动类型提升

- 当容量小的数据类型的变量和容量大的数据类型的变量做运算时，结果自动提升为容量大的类型
  - 容量大小指的是表示数的范围大小
- byte、char、short -> int -> long -> float -> double
  - 当 byte、char、short 三种类型的变量做运算时，结果为 int 类型
    - **包括**同种类型之间做运算

## 强制类型转换

- 强制类型转换是自动类型提升的逆运算
- 需要使用强转符：`()`
- 强制类型转换可能导致精度损失
 */
public class TypeConversion {
    public static void main(String[] args) {
        byte b1 = 127;
        int i1 = 1;
        int i2 = b1 + i1;
        long l1 = b1 + i1;
        System.out.println(i2);
        System.out.println(l1);

        byte b2 = 127;
        short s1 = 233;
        int i3 = b2 + s1;
        System.out.println(i3);

        double b3 = 123.4;
        int i4 = (int) b3; // 截断操作
        System.out.println(i4);

        int i5 = 128;
        byte b4 = (byte) i5; // -128
        System.out.println(b4);
    }
}
