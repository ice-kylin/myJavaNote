package typeofdata;

/*
# 字符类型

- char
  - 占用存储空间：1 字符 = 2 字节
  - 定义 char 型变量，通常使用一对 `''`，内部只能写一个字符

## 表示方式

- 声明一个字符
- 转义字符
  - `\b` —— 退格符
  - `\n` —— 换行符
  - `\r` —— 回车符
  - `\t` —— 制表符
  - `\'` —— 单引号
  - `\"` —— 双引号
- Unicode 字符

## 字符集

字符 -> 字符集 -> 二进制
 */
public class CharVariable {
    public static void main(String[] args) {
        char c1 = 'a';
        System.out.println(c1);

        char c2 = '\n';
        System.out.println("Hello" + c2 + "World");

        char c3 = '\t';
        System.out.println("Hello" + c3 + "World");

        char c4 = '\u0123';
        System.out.println(c4);
    }
}
