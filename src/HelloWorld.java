/*
# 第一个 Java 程序总结

## 编写、编译、运行过程

1. 编写 —— 将编写的 Java 代码保存在以 `.java` 结尾的源文件中
2. 编译 —— 使用 `javac.exe` 命令编译 Java 源文件
  - 格式：`javac 源文件名.java`
3. 运行 —— 使用 `java.exe` 命令解释运行字节码文件
  - 格式：`java 类名`

## 说明

- 在一个 Java 源文件中可以声明多个 `class`
  - 但是只能最多有一个类声明为 `public`
  - 而且声明为 `public` 的类的类名必须与源文件名相同（文件名只有一个）
- 程序的入口是 `main()` 方法
  - 格式是固定的
- 输出语句
  - `System.out.println()` —— 先输出数据，然后换行
  - `System.out.print()` —— 只输出数据
- 每一行执行语句都以 `;` 结束
- 编译以后会生成一个或多个字节码文件
  - 字节码文件的文件名与 Java 源文件中的类名相同
 */
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
