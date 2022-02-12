package collectionmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;

/*
# `Map` 接口

- `Map` 接口：双列集合，用来存储一对一对的数据（key - value）（类似于高中的函数：y = f(x)）
  - `HashMap`
    - 作为 `Map` 的主要实现类
    - 线程不安全的，效率高
    - 可以存储 `null` 的 key 和 value
    - 底层
      - 数组 + 链表（JDK 7 之前）
      - 数组 + 链表 + 红黑树（JDK 8 之后）
    - `LinkedHashMap`
      - 保证在遍历 `Map` 元素时，可以按照添加的顺序进行遍历
        - 原因：在原有的 `HashMap` 底层结构基础上，添加了一对指针，指向前一个和后一个元素
        - 对于频繁的遍历操作，此类执行效率高于 `HashMap`
  - `TreeMap`
    - 保证按照添加的 key - value 对进行排序，实现遍历排序
    - 此时考虑 key 的自然排序或定制排序
    - 底层使用红黑树
  - `Hashtable`
    - 作为 `Map` 的古老实现类
    - 不能存储 `null` 的 key 和 value
    - `Properties`
      - 常用来处理配置文件
      - key 和 value 都是 String 类型

## `Map` 结构的理解

- key：无序的、不可重复的，使用 Set 存储所有的 key
  - key 所在的类要重写 `equals()` 和 `hashcode()` 方法（以 `HashMap` 为例）
- value：无序的、可重复的，使用 Collection 存储所有的 value
  - value 所在的类要重写 `equals()` 方法
  - 一个键值对：key - value 构成了一个 Entry 对象
  - `Map` 中的 entry：无序的、不可重复的，使用 Set 存储所有的 entry
 */
public class MapTest {
    /*
    ## `HashMap` 的底层实现原理（JDK 7 为例）
     */
    @Test
    public void test1() {
        HashMap hashMap = new HashMap(); // 1. 实例化以后，底层创建了长度是 16 的一维数组 Entry[] table

        // ... 可能已经执行过多次 `put()` 操作
        hashMap.put("key", "value");
        /*
        2. 首先调用 `"key"` 所在类的 `hashCode()` 计算 key1 的哈希值，此哈希值经过某种算法计算以后，得到在 Entry 数组中的存放位置
          - 如果此位置上的数据为空：此时键值对 key1 - value1 添加成功（添加成功情况一）
          - 如果此位置上的数据不为空（意味着此位置上存在一个或多个数据（以链表的形式存在）），比较 key1 和已经存在的一个或多个数据的哈希值
            - 如果 `key1` 的哈希值与已经存在的数据的哈希值都不相同，此时 `key1` - `value1` 添加成功（添加成功情况二）
            - 如果 `key1` 的哈希值与已经存在的某个（或多个）数据（key2 - value2）的哈希值相同，继续比较：调用 key 所在类的 `equals()` 方法（key1.equals(key2)）
              - 如果 `equals()`（都）返回 `false`：此时 key1 - value1 添加成功（添加成功情况三）
              - 如果 `equals()` 返回 `true`：使用 value1 替换 value2
          - 在不断添加的过程中，会涉及到扩容问题
            - 默认的扩容方式：扩容为原来的 2 倍，并将原有的数据复制过来
         */

        System.out.println(hashMap);
    }
}
