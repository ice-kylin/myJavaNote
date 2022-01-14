package multithreading;

/*
# `Thread` 类中的常用方法

- `start()`
  1. 启动当前线程
  2. 调用当前线程的 `run()` 方法
- `run()`
  - 通常需要重写 `Thread` 类中的此方法，将要创建的线程要执行的操作声明在此方法中
- `currentThread()`
  - 静态方法，返回执行当前代码的线程
- `getName()`
  - 获取当前线程的名字
- `setName()`
  - 设置当前线程的名字
- `yield()`
  - 释放当前 CPU 的执行权
- `join()`
  - 在线程 a 中调用线程 b 的 `join()` 方法，此时线程 a 就进入阻塞状态
  - 直到线程 b 完全执行完以后，线程 a 才结束阻塞状态
- `stop()`
  - 已过时
  - 当执行此方法时，强制结束当前线程
- `sleep()`
  - 让当前线程“睡眠”指定的毫秒数
  - 在指定的毫秒时间内，当前线程是阻塞状态
- `isAlive()`
  - 判断当前线程是否存活
 */
public class CommonMethodTest {
    public static void main(String[] args) {
        TestThread t1 = new TestThread();
        // TestThread t2 = new TestThread("TestThread-2");
        t1.setName("TestThread-1");
        Thread.currentThread().setName("MainThread");

        t1.start();
        // t2.start();

        for (int i = 0; i <= 100; i++) {
            if (i % 2 != 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ": " + i);
            }

            if (i == 50) {
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(t1.isAlive());
        }
    }
}

class TestThread extends Thread {
    public TestThread() {
    }

    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }

            if (i % 10 == 0) {
                yield();
            }
        }
    }
}
