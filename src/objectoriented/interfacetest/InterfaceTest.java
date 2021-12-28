package objectoriented.interfacetest;

/*
# 接口

- 接口使用 `interface` 关键字来定义
- Java 中接口和类是并列的结构
- 如何定义接口：定义接口中的成员
  - JDK 7 及以前
    - 只能定义全局常量和抽象方法
      - 全局常量：`public static final`，但是书写时可以省略不写
      - 抽象方法：`public abstract`
  - JDK 8 及以后
    - 除了定义全局常量和抽象方法之外，还可以定义静态方法和默认方法
      - 静态方法：`public static`
        - 接口中定义的静态方法，只能通过接口来调用
      - 默认方法：`public default`
        - 通过实现类的对象，可以调用接口中的默认方法
        - 如果实现类中重写了接口中的默认方法，调用时仍然调用的是重写的方法
        - 如果子类（或实现类）继承的父类和实现的接口中声明了同名同参数的方法，那么子类在没有重写此方法的情况下，默认调用的是父类中同名同参数的方法（类优先原则）
        - 如何在子类（或实现类）中调用父类、接口中被重写的方法
          - `接口名.super.方法名()`
  - 接口中不能定义构造器，意味着接口不可以实例化
- Java 开发中接口通过让类去实现（`implements`）的方式来使用
  - 如果实现类覆盖了接口中的所有抽象方法，则此实现类就可以实例化
  - 如果实现类没有覆盖接口中所有的抽象方法，则此实现类仍为一个抽象类
- Java 类可以实现多个接口：弥补了 Java 单继承性的局限性
  - 格式：`class A extends BB implements C, D, E...`
- 接口的具体使用体现了多态性
- 接口实际上可以看作是一种规范
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);

        Plane p = new Plane();
        p.fly();
        p.stop();

        System.out.println(p.MAX_SPEED);
        System.out.println(p.MIN_SPEED);

        Flyable.m1();
        p.m2();
    }
}

interface Flyable {
    // 全局常量
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1; // 省略了 public static final

    // 抽象方法
    public abstract void fly();

    void stop(); // 省略了 public abstract

    // 静态方法
    static void m1() {
        System.out.println("m1");
    } // 省略了 public

    // 默认方法
    default void m2() {
        System.out.println("m2");
    } // 省略了 public
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}
