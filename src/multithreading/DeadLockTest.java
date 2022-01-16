package multithreading;

/*
# 死锁

- 死锁的理解
  - 不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
- 说明
  - 出现死锁后，不会出现异常、不会出现提示，只是所有的线程都处于阻塞状态，无法继续
  - 使用同步时，要避免出现死锁
- 解决方法
  - 专门的算法、原则
  - 尽量减少同步资源的定义
  - 尽量避免嵌套同步
 */
public class DeadLockTest {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        new Thread(() -> {
            synchronized (s1) {
                s1.append("a");
                s2.append("b");

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                synchronized (s2) {
                    s1.append("1");
                    s2.append("2");
                }
            }

            System.out.println(s1);
            System.out.println(s2);
        }).start();

        new Thread(() -> {
            synchronized (s2) {
                s1.append("a");
                s2.append("b");

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

                synchronized (s1) {
                    s1.append("1");
                    s2.append("2");
                }
            }

            System.out.println(s1);
            System.out.println(s2);
        }).start();
    }
}
