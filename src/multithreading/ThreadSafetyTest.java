package multithreading;

/*
# 线程安全问题

- 例子
  - 问题：卖票过程中出现了重票、错票 -> 出现了线程安全问题
  - 问题出现的原因
    - 当某个线程操作车票的过程中，尚未操作完成时，其它线程参与进来也操作车票
  - 如何解决
    - 当线程 a 在操作车票的时候，其它线程不能参与进来
    - 直到线程 a 操作完成车票之后，线程才可以开始操作车票
    - 这种情况即使线程 a 出现了阻塞，也不能被改变
- 在 Java 中，通过同步机制解决线程安全问题
  1. 方式一：同步代码块
    - `synchronized (同步监视器) { 需要被同步的代码 }`
      1. 操作共享数据的代码，即为需要被同步的代码
        - 不能包含代码多了，也不能包含代码少了
      2. 多个线程共同操作的变量，即为共享数据
      3. 同步监视器，俗称：锁
        - 任何一个类的对象，都可以充当锁
        - 要求：多个线程必须要共用**同一把锁**
        - 在实现 `Runnable` 接口创建多线程的方式中，可以考虑使用 `this` 充当同步监视器
        - 在继承 `Thread` 类创建多线程的方式中，慎用 `this` 充当同步监视器
          - 考虑使用当前类充当同步监视器
  2. 方式二：同步方法
- 同步的方式，解决了线程的安全问题 —— 好处
- 操作同步代码时，只能有一个线程参与，其它线程等待，相当于是一个单线程的过程，效率低 —— 局限性
 */
public class ThreadSafetyTest {
    public static void main(String[] args) {
        WinRunnable1 w = new WinRunnable1();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WinRunnable1 implements Runnable {
    private final Win win = new Win(10);

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                // synchronized (win) {
                if (win.getTicketNum() > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    win.sellATicket();
                } else {
                    break;
                }
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
