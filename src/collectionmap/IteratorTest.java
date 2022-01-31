package collectionmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/*
# 集合元素的遍历操作：`Iterator` 接口（迭代器）

- `Iterator<E> iterator()`
  - 集合对象每次调用 `iterator()` 方法都得到一个全新的迭代器对象
  - 默认游标都在集合的第一个元素之前
- `boolean hasNext()`
- `E next()`
- `default void remove()`
  - 可以在遍历的时候删除集合中的元素
  - 此方法不同于集合中直接调用 `remove()`
  - 如果还未调用 `next()` 或在上一次调用 `next()` 方法之后已经调用了 `remove()` 方法
    - 再调用 `remove()` 方法都会报 `IllegalStateException` 异常
 */
public class IteratorTest {
    @Test
    public void test1() {
        Collection c1 = new ArrayList();

        c1.add(233);
        c1.add("Hello");
        c1.add(new Date());
        c1.add("Java");

        Iterator iterator = c1.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2() {
        Collection c1 = new ArrayList();

        c1.add(233);
        c1.add("Hello");
        c1.add(new Date());
        c1.add("Java");
        c1.add("Java");
        c1.add("Java");

        Iterator iterator1 = c1.iterator();

        while (iterator1.hasNext()) {
            Object next = iterator1.next();

            if ("Java".equals(next)) {
                iterator1.remove();
            }
        }

        Iterator iterator2 = c1.iterator();

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
