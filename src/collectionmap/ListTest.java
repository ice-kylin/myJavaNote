package collectionmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
# `List` 接口

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

- 内部声明了 Node 类型的 `first` 和 `last` 属性，默认值为 `null`
- 双向链表

## `Vector` 的源码分析

- JDK 7.0 情况下 `ArrayList` 差不多
- 需要扩容时，扩容为原来容量的 2 倍

## `List` 接口的常用方法

1. `void add(int index, E element)`：在 `index` 位置插入 `element` 元素
2. `boolean addAll(int index, Collection<? extends E> c)`：从 `index` 位置开始将 `c` 中的所有元素添加到当前集合中
3. `E get(int index)`：获取指定 `index` 位置的元素
4. `int indexOf(Object o)`：返回 `o` 在集合中首次出现的位置，如果不存在，返回 `-1`
5. `int lastIndexOf(Object o)`：返回 `o` 在当前集合中最后出现的位置，如果不存在，返回 `-1`
6. `E remove(int index)`：移除指定 `index` 位置的元素，并返回此元素
7. `E set(int index, E element)`：设置指定 `index` 位置的元素为 `element`
8. `List<E> subList(int fromIndex, int toIndex)`：返回从 `fromIndex` 到 `toIndex` 位置的左闭右开区间的字集合

### 总结

- 增：`boolean add(E e)`
- 删
  - `boolean remove(Object o)`
  - `E remove(int index)`
- 改：`E set(int index, E element)`
- 查：`E get(int index)`
- 插：`void add(int index, E element)`
- 长度：`int size()`
- 遍历
  - `Iterator` 迭代器方式
  - 增强 for 循环
  - 普通的循环
 */
public class ListTest {
    /*
    - `void add(int index, E element)`：在 `index` 位置插入 `element` 元素
    - `boolean addAll(int index, Collection<? extends E> c)`：从 `index` 位置开始将 `c` 中的所有元素添加到当前集合中
     */
    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(233);
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add("Java");
        arrayList.add("JavaFX");

        System.out.println(arrayList);

        arrayList.add(3, "!");

        System.out.println(arrayList);

        arrayList.addAll(4, Arrays.asList("Python", "Scala", "C"));

        System.out.println(arrayList);
    }

    /*
    - `E get(int index)`：获取指定 `index` 位置的元素
    - `int indexOf(Object o)`：返回 `o` 在集合中首次出现的位置，如果不存在，返回 `-1`
    - `int lastIndexOf(Object o)`：返回 `o` 在当前集合中最后出现的位置，如果不存在，返回 `-1`
    - `E remove(int index)`：移除指定 `index` 位置的元素，并返回此元素
     */
    @Test
    public void test2() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(233);
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add(233);
        arrayList.add("Java");

        Object o = arrayList.get(3);
        System.out.println(o);

        int i = arrayList.indexOf("Hello");
        System.out.println(i);

        System.out.println(arrayList.lastIndexOf(233));

        Object o1 = arrayList.remove(1);
        System.out.println(o1);
        System.out.println(arrayList);
    }

    /*
    - `E set(int index, E element)`：设置指定 `index` 位置的元素为 `element`
    - `List<E> subList(int fromIndex, int toIndex)`：返回从 `fromIndex` 到 `toIndex` 位置的左闭右开区间的字集合
     */
    @Test
    public void test3() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(233);
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add("Java");

        arrayList.set(0, "C++");
        System.out.println(arrayList);

        List list = arrayList.subList(1, arrayList.size() - 1);
        System.out.println(list);
    }

    /*
    - 使用 `Iterator` 迭代器遍历
    - 使用增强 for 循环遍历
    - 使用普通的循环
     */
    @Test
    public void test4() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(233);
        arrayList.add("Hello");
        arrayList.add("World");
        arrayList.add("Java");
        arrayList.add("JavaFX");

        Iterator iterator = arrayList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        for (Object o : arrayList) {
            System.out.println(o);
        }

        System.out.println();

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
