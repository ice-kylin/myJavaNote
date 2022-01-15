package multithreading;

/*
# 创建多线程的方式二：实现 `Runnable` 接口

1. 创建一个实现了 `Runnable` 接口的类
2. 实现类去实现 `Runnable` 中的抽象方法
3. 创建实现类的对象
4. 将此对象作为参数传递到 `Thread` 类的构造器中，创建 `Thread` 类的对象
5. 通过 `Thread` 类的对象调用 `start()`

## 两种创建多线程方式的对比

- 开发中优先选择实现 `Runnable` 接口的方式
  - 原因
    1. 实现的方式没有类的单继承性的局限性
    2. 实现的方式更适合处理多个线程有共享数据的情况
- 联系：`public class Thread implements Runnable`
- 相同点
  - 两种方式都需要重写 `run()` 方法，将线程要执行的逻辑声明在 `run()` 中
  - 两种方式想要启动线程，都是调用的 `Thread` 类中的 `start()` 方法
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();

        new Thread(myThread1).start();
        new Thread(myThread1).start();
    }
}

// 创建一个实现了 `Runnable` 接口的类
class MyThread1 implements Runnable {
    // 实现类去实现 `Runnable` 中的抽象方法
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
