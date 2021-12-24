package objectoriented.statictest;

/*
# 设计模式

- 设计模式是在大量实践中总结和理论化之后优选的代码模式、编程风格、以及解决问题的思考方式
- 设计模式免去我们自己再思考和摸索

## 单例设计模式

- 所谓类的单例设计模式就是采取一定的方法保证在整个软件系统中，对某个类只能存在一个对象实例
  - 减少了系统性能开销
- 如何实现
  - 饿汉式
  - 懒汉式
- 区分饿汉式和懒汉式
  - 饿汉式
    - 好处：线程安全
    - 坏处：对象加载时间过长
  - 懒汉式
    - 好处：延迟对象的创建
    - 目前写法的坏处：线程不安全
 */
public class SingletonTest {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();

        System.out.println(bank1 == bank2);
    }
}

// 饿汉式
class Bank {
    private static Bank instance = new Bank();

    private Bank() {
    }

    public static Bank getInstance() {
        return instance;
    }
}
