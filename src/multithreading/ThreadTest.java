package multithreading;

/*
# 线程的创建和使用

## 方式一：继承于 `Thread` 类

1. 创建一个继承于 `Thread` 类的子类
2. 重写 `Thread` 类的 `run()` 方法（将此线程执行的操作声明在 `run()` 中）
3. 创建 `Thread` 类的子类的对象
4. 通过此对象调用 `start()` 方法
  1. 启动当前线程
  2. 调用当前线程的 `run()` 方法

## 说明

- 不能通过直接调用 `run()` 的方式启动线程
- 不可以再让已经 `start()` 的线程去执行，会抛出 `IllegalThreadStateException` 异常
 */
public class ThreadTest {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread(); // 创建 `Thread` 类的子类的对象
        MyThread myThread2 = new MyThread(); // 需要创建一个新的线程对象

        myThread1.start(); // 通过此对象调用 `start()` 方法
        myThread2.start();

        System.out.println("Hello"); // 仍然是在 `main` 线程中执行的
    }
}

// 创建一个继承于 `Thread` 类的子类
class MyThread extends Thread {
    // 重写 `Thread` 类的 `run()` 方法
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
