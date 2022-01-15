package multithreading;
/*
# 线程的生命周期

- 新建
  - ↓：调用 `start()`
- 就绪
  - ↓：获取 CPU 的执行权
  - ↑
    - 失去 CPU 的执行权
    - `yield()`
- 运行
  - ↡
    - 执行完 `run()`
    - 调用线程的 `stop()`
    - 出现 Error / Exception 且没有处理
  - ↓
    - `sleep()`
    - `join()`
    - 等待同步锁
    - `wait()`
    - `suspend()`
- 阻塞
  - ↟
    - `sleep()` 的时间到
    - `join()` 结束
    - 获取同步锁
    - `notify()` / `notifyAll()`
    - `resume()`
- 死亡
 */
public class ThreadLifeCycleTest {
    public static void main(String[] args) {

    }
}
