package basicgrammar;

/*
# 变量

- 变量是内存中的一个储存区域
- 该区域的数据可以在同一类型范围内不断变化
- 变量是程序中最基本的存储单元，包含
  - 变量类型
  - 变量名
  - 存储的值

# 变量的使用

- Java 定义变量的格式
  - `数据类型 变量名 = 变量值;`
- 变量必须先**声明、赋值**后使用
- 变量都定义在其作用域内。在作用域内，它是有效的。换句话说，出了作用域，就失效了
- 同一个作用域内，不可以声明两个同名的变量
 */
public class Variable {
    public static void main(String[] args) {
        // 变量的定义
        int myAge = 19;
        // 变量的使用
        System.out.println(myAge);

        // 变量的声明
        int myHeight;
        // 变量的赋值
        myHeight = 185;
        // 变量的使用
        System.out.println(myHeight);
    }
}
