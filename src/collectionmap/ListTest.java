package collectionmap;

import org.junit.Test;

/*
# `List` 接口`

- List` 接口：存储有序的、可重复的数据（动态数组）
  - `ArrayList`
    - 作为 `List` 接口的主要实现类
    - 线程不安全的，效率高
    - 底层使用 `Object[] elementData` 存储
  - `LinkedList`
    - 对于频繁的插入、删除操作，使用此类效率比 `ArrayList` 高
    - 底层使用双向链表存储
  - `Vector`
    - 作为 `List` 接口的古老实现类
    - 线程安全的，效率低
    - 底层使用 `Object[] elementData` 存储

## 说明

- `ArrayList`、`LinkedList`、`Vector` 三者的异同
  - 相同点
    - 三个类都实现了 `List` 接口
    - 存储数据的特点相同：存储有序的、可重复的数据
  - 不同点
    - 见上

## `ArrayList` 的源码分析

- JDK 7.0 情况下
  - `ArrayList arrayList = new ArrayList();`：创建了长度是 `10` 的 `Object[]` 数组 `elementData`
  - `arrayList.add()`
    - 如果添加导致底层数组 `elementData` 容量不够，则扩容
    - 默认情况下扩容为原来容量的 1.5 倍，同时需要将原有数组中的数据复制到新的数组中
    - 结论：建议开发中使用带参的构造器：`ArrayList(int initialCapacity)`
- JDK 8.0 情况下
  - `ArrayList arrayList = new ArrayList();`
    - 底层 `Object[] elementData` 初始化为 `{}`，并没有船舰长度为 10 的 `Object[]` 数组
  - `arrayList.add()`
    - 第一次调用 `add()` 时，底层才创建了长度为 `10` 的数组
    - 后续的添加和扩容操作和 JDK 7.0 无异

### 小结

- JDK 7.0 中的 ArrayList 的对象的创建类似于单例的饿汉式
  - 而 JDK 8.0 中的 ArrayList 的对象的创建类似于单例模式的懒汉式，延迟了数组的创建，节省内存

## `LinkedList` 的源码分析
 */
public class ListTest {
    /*

     */
    @Test
    public void test1() {
    }
}
