package objectoriented.innerclass;

/*
# 内部类

- Java 中允许将一个类 A 声明在另一个类 B 中，则类 A 就是内部类，类 B 称为外部类
- 内部类的分类
  - 成员内部类（静态、非静态）
  - 局部内部类（方法内、代码块内、构造器内）
- 成员内部类
  - 一方面，作为外部类的成员
    - 调用外部类的结构
    - 可以被 `static` 修饰
    - 可以被 4 种不同的权限修饰符修饰
  - 另一方面，作为一个类
    - 类内可以定义属性、方法、构造器
    - 可以被 `final` 修饰，表示此类不能被继承（不使用 `final` 就可以被继承）
    - 可以被 `abstract` 修饰
- 3 个问题
  1. 如何实例化成员内部类的对象
  2. 如何在成员内部类中区分调用外部类的结构
  3. 开发中局部内部类的使用
 */
public class InnerClassTest {
    public static void main(String[] args) {
        Nature.Dog d = new Nature.Dog(); // 创建 Dog 实例（静态的成员内部类）
        d.bark();

        Nature n = new Nature();
        Nature.Bird b1 = n.new Bird(); // 创建 Bird 实例（非静态的成员内部类）

        Nature.Bird b2 = new Nature().new Bird(); // 创建 Bird 实例（非静态的成员内部类）

        b1.call();
        b2.call();

        b1.display("1");
    }
}

class Nature {
    String name = "3";

    public static class Dog {
        public void bark() {
            System.out.println("狗叫...");
        }
    }

    public class Bird {
        String name = "2";

        public void call() {
            System.out.println("鸟叫...");
        }

        public void display(String name) {
            System.out.println("name = " + name); // 方法的形参
            System.out.println("this.name = " + this.name); // 内部类的属性
            System.out.println("Nature.this.name = " + Nature.this.name); // 外部类的属性
        }
    }
}
