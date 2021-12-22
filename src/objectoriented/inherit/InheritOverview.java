package objectoriented.inherit;

/*
# 面向对象特征二：继承性

- 继承性的好处
  - 减少了代码的冗余，提高了代码的复用性
  - 便于功能的扩展
  - 为之后的多态性的使用提供了前提
- 继承性的格式
  - `class A extends B {}`
    - A：子类 / 派生类 / subclass
    - B：父类 / 超类 / superclass
- 体现：一旦子类 A 继承父类 B 以后，子类 A 中就获取了父类 B 中声明的结构（属性、方法）
  - 特别的，父类中声明为 `private` 的属性和方法，子类继承父类以后，仍然认为获取了父类中私有的结构
  - 只是因为封装性的影响，使得子类不能直接调用父类的结构而已
- 子类继承父类以后，还可以声明自己特有的属性或方法以实现功能的扩展

## 规定

- 一个类可以被多个子类继承
- Java 中类的单继承性：一个类只能有一个父类
- 子父类是相对的概念
- 子类直接继承的父类称为直接父类，间接继承的父类称为间接父类
- 子类继承父类以后，就获取了直接父类以及所有间接父类中声明的属性和方法
- 如果没有显式的声明一个类的父类的话，则此类继承于 `java.lang.Object` 类
  - 所有的 Java 类（除 `java.lang.Object` 类之外）都直接或间接的继承于 `java.lang.Object` 类
  - 意味着所有的 Java 类具有 `java.lang.Object` 类声明的功能
 */
public class InheritOverview {
    public static void main(String[] args) {

    }
}
