package multithreading;

/*
# 线程的通信

- 涉及到的三个方法
  - `wait()`：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
  - `notify()`：一旦执行此方法，就会唤醒被 `wait()` 的一个线程
    - 如果有多个线程被 `wait()`，就会唤醒优先级高的那一个
  - `notifyAll()`：一旦执行此方法，就会唤醒所有被 `wait()` 的线程
- 说明
  - `wait()`、`notify()`、`notifyAll()` 三个方法的使用必须使用在同步代码块或同步方法中
  - `wait()`、`notify()`、`notifyAll()` 三个方法的调用者必须是同步代码块或同步方法中的同步监视器
  - `wait()`、`notify()`、`notifyAll()` 三个方法是定义在 `java.lang.Object` 类中的

## `sleep()` 和 `wait()` 的异同

- 相同点：一旦执行方法，都可以使得当前线程进入阻塞状态
- 不同点
  - 两个方法声明的位置不同
    - `Thread` 类中声明 `sleep()`
    - `Object` 类中声明 `wait()`
  - 调用的要求不同
    - `sleep()` 可以在任何需要的场景下使用
    - `wait()` 必须使用在同步代码块或同步方法中
  - 关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中
    - `sleep()` 不会释放同步监视器
    - `wait()` 会释放同步监视器
 */
public class ThreadCommunicationTest {
    public static void main(String[] args) {
        NumRunnable r = new NumRunnable();

        new Thread(r).start();
        new Thread(r).start();
    }
}

class NumRunnable implements Runnable {
    private int currentNum = 1;
    private final Object obj = new Object();

    @Override
    public void run() {
        do {
            synchronized (obj) {
                obj.notify();

                if (currentNum > 10) {
                    break;
                } else {
                    System.out.println(Thread.currentThread().getName() + ": " + currentNum++);

                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } while (true);
    }
}
