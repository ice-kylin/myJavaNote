package multithreading;

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

    }
}
