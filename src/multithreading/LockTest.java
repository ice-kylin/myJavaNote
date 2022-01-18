package multithreading;

import java.util.concurrent.locks.ReentrantLock;

/*
# 解决线程安全的方式三：Lock 锁（JDK 5.0 新增）

- 步骤
  1. 实例化 `ReentrantLock`
  2. 调用锁定方法 `lock()`
  3. 调用解锁方法 `unlock()`
- `synchronized` 与 Lock 的异同
  - 相同点：二者都可以解决线程安全问题
  - 不同点
    - `synchronized` 机制在执行完相应的同步代码以后，自动的释放同步监视器
    - Lock 需要手动的启动同步（`lock()`），同时结束同步也需要手动的实现（`unlock()`）
  - 优先使用顺序：Lock -> 同步代码块（已经进入了方法体，分配了相应资源） -> 同步方法（在方法体之外）
 */
public class LockTest {
    public static void main(String[] args) {
        WinRunnable3 w = new WinRunnable3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);
        Thread t4 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t4.setName("窗口四");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class WinRunnable3 implements Runnable {
    private final Win win = new Win(10);
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            if (win.getTicketNum() > 0) {
                try {
                    lock.lock();

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
                } finally {
                    lock.unlock();
                }
            } else {
                break;
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
