package objectoriented;

/*
# 属性和方法

1. 设计类，其实就是设计类的成员
  - 属性 / 成员变量 / field / 域、字段
  - 方法（method） / 成员方法 / 函数
  - 创建类的对象 / 类的实例化 / 实例化类
2. 类和对象的使用（面向对象思想落地的实现）
  1. 创建类，设计类的成员
  2. 创建类的对象
  3. 通过 `对象.属性` 或 `对象.方法()` 调用对象的结构
3. 如果创建了一个类的多个对象，则每个对象都独立的拥有一套类的属性（非 `static` 的）
  - 意味着如果修改一个对象的属性 a,则不影响另外一个对象属性 a 的值
4. 对象的内存解析
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person(); // 创建类的对象
        Person p2 = new Person();

        // 调用对象的结构：属性、方法
        // 调用属性
        p1.name = "Issac";
        p1.isMale = true;
        p1.age = 19;

        System.out.println("p1.name = " + p1.name);
        System.out.println("p1.age = " + p1.age);
        System.out.println("p1.isMale = " + p1.isMale);

        System.out.println();

        // 调用方法
        p1.eat();
        p1.sleep();

        System.out.println();

        System.out.println("p2.name = " + p2.name);
        System.out.println("p2.isMale = " + p2.isMale);

        System.out.println();

        Person p3 = p1; // 将 p1 变量保存的对象地址赋值给 p3，导致 p1 和 p3 指向了对空间中的同一个对象实体
        System.out.println("p3.name = " + p3.name);
    }
}

class Person {
    // 属性
    String name;
    int age = 1;
    boolean isMale;

    // 方法
    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }
}
