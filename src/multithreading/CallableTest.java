package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
# 创建线程的方式三：实现 `Callable` 接口（JDK 5.0 新增）

## 步骤

1. 创建一个实现 `Callable` 接口的实现类
2. 实现 `call()` 方法：将此线程需要执行的操作声明在 `call()` 中
3. 创建 `Callable` 接口实现类的对象
4. 将此 `Callable` 接口实现类的对象作为参数传递到 `FutureTask` 构造器中，创建 `FutureTask` 对象
5. 将此 `FutureTask` 的对象作为参数传递到 `Thread` 类的构造器中，创建 `Thread` 对象并调用 `start()` 方法
6. 获取 `Callable` 接口的实现类中 `call()` 方法的返回值
  - `get()` 返回值即为 `FutureTask` 构造器参数 `Callable` 接口实现类实现的 `call()` 方法的返回值

## 如何理解实现 `Callable` 接口的方式创建多线程比实现 `Runnable` 接口创建多线程的方式强大

- `call()` 可以有返回值
- `call()` 可以抛出异常，被外面的操作捕获，获取异常的信息
- `Callable` 是支持泛型的
 */
public class CallableTest {
    public static void main(String[] args) {
        // 3. 创建 Callable 接口实现类的对象
        NumCallable numCallable = new NumCallable();
        // 4. 将此 Callable 接口实现类的对象作为参数传递到 FutureTask 构造器中，创建 FutureTask 对象
        FutureTask futureTask = new FutureTask(numCallable);
        // 5. 将此 FutureTask 的对象作为参数传递到 Thread 类的构造器中，创建 Thread 对象并调用 start() 方法
        new Thread(futureTask).start();

        try {
            // 6. 获取 Callable 接口的实现类中 call() 方法的返回值
            // get() 返回值即为 FutureTask 构造器参数 Callable 接口实现类实现的 call() 方法的返回值
            System.out.println("总和：" + futureTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}

// 1. 创建一个实现 Callable 接口的实现类
class NumCallable implements Callable {
    // 2. 实现 call() 方法：将此线程需要执行的操作声明在 call() 中
    @Override
    public Object call() {
        int sum = 0;

        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }

        return sum;
    }
}
