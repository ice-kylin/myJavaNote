package objectoriented.finaltest;

/*
# `final` 关键字

- `final` 关键字可以用来修饰的结构：类、方法、变量
  - `final` 用来修饰类：此类不能被其它类继承
    - `String` 类
    - `System` 类
    - `StringBuffer` 类
  - `final` 用来修饰方法：此方法不可以被重写
    - 比如 `Object` 类中的 `.getClass()` 方法
  - `final` 用来修饰变量：此时的变量就是一个“常量”
    - `final`修饰属性
      - 可以考虑赋值的位置有
        - 显式初始化
        - 代码块中初始化
        - 构造器中初始化
    - `final` 修饰局部变量
      - 尤其是使用 `final` 修饰形参时，表明此形参是一个常量
        - 当调用此方法时，给常量形参赋一个实参
        - 一旦赋值以后，就只能在方法体内使用此形参，但是不能重新赋值
- `static final`：用来修饰属性（全局常量）、方法（比较少）
 */
public class FinalTest {
    public static void main(String[] args) {

    }
}
