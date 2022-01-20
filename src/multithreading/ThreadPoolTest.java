package multithreading;

import java.util.concurrent.*;

/*
# 创建线程的方式四：使用线程池

## 好处

- 提高响应数据（减少了创建新线程的时间）
- 降低资源消耗（重复利用线程池中线程，不需要每次都创建）
- 便于线程管理
  - `corePoolSize`：核心池的大小
  - `maximumPoolSize`：最大线程数
  - `keepAliveTime`：线程没有任务时最多多长时间后会终止
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 1. 提供指定线程数量的线程池
        // ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        System.out.println("service.getClass() = " + service.getClass());

        // service.setCorePoolSize(16);
        // service.setMaximumPoolSize(16);

        // 2. 执行指定的线程的操作，需要提供实现 Runnable 接口或 Callable 接口实现类的对象
        service.execute(new NumRunnable1()); // 适合使用于 Runnable
        FutureTask futureTask = (FutureTask) service.submit(new NumCallable1()); // 适合使用于 Callable

        System.out.println("futureTask.getClass() = " + futureTask.getClass());

        try {
            System.out.println("总和：" + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 3. 关闭连接池
        service.shutdown();
    }
}

class NumRunnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumCallable1 implements Callable {
    @Override
    public Object call() {
        int sum = 0;

        for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                sum += i;
            }
        }

        return sum;
    }
}
