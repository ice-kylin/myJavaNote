package multithreading;

/*
# 线程优先级

- 3 个优先级常量
  - `MAX_PRIORITY`：`10`
  - `MIN_PRIORITY`：`1`
  - `NORM_PRIORITY`：`5`
    - 默认的优先级
- 获取和设置当前线程的优先级
  - `getPriority()`：获取线程的优先级
  - `setPriority()`：设置线程的优先级
- 高优先级的线程要抢占低优先级线程 CPU 的执行权
  - 但是只是从概率上来讲，高优先级的线程高概率的情况下被执行
  - 并不意味着只有当高优先级的线程执行完以后，低优先级的线程才执行
 */
public class ThreadPriorityTest {
    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();

        System.out.println(Thread.currentThread().getPriority());
    }
}

class TestThread2 extends Thread {
    @Override
    public void run() {
        System.out.println(getPriority());
    }
}
