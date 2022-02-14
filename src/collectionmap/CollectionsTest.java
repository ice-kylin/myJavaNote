package collectionmap;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
# `Collection` 工具类

- 操作 `Collection` 和 `Map` 的工具类
 */
public class CollectionsTest {
    /*
    - `static void reverse(List<?> list)`
      - 反转 `List` 中元素的顺序
    - `static void shuffle(List<?> list)`
      - 对 `List` 集合中的元素进行随机排序
    - `static <T extends Comparable<? super T>> void sort(List<T> list)`
      - 根据元素的自然排序对指定 `List` 集合元素按升序排序
    - `static <T> void sort(List<T> list, Comparator<? super T> c)`
      - 根据指定的 `Comparator` 产生的顺序对 `List` 集合元素进行排序
    - `static void swap(List<?> list, int i, int j)`
      - 将指定 `List` 集合中的 `i` 处元素和 `j` 处元素进行交换
     */
    @Test
    public void test1() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(233);
        arrayList.add(666);
        arrayList.add(120);
        arrayList.add(110);
        arrayList.add(114);

        Collections.sort(arrayList);
        System.out.println(arrayList);

        Collections.sort(arrayList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    return ((Integer) o2).compareTo((Integer) o1);
                } else {
                    throw new IllegalArgumentException("传入的参数类型不一致");
                }
            }
        });
        System.out.println(arrayList);

        Collections.reverse(arrayList);
        System.out.println(arrayList);

        Collections.swap(arrayList, 0, arrayList.size() - 1);
        System.out.println(arrayList);

        Collections.shuffle(arrayList);
        System.out.println(arrayList);
    }

    /*
    - `static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)`
      - 根据元素的自然排序，返回给定集合中的最大元素
    - `static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp)`
      - 根据 Comparator 指定的顺序，返回给定集合中的最大元素
    - `static <T extends Object & Comparable<? super T>> T min(Collection<? extends T> coll)`
    - `static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp)`
    - `static int frequency(Collection<?> c, Object o)`：返回指定集合中指定元素的出现次数
    - `static <T> void copy(List<? super T> dest, List<? extends T> src)`：将 src 中的内容复制到 dest 中
    - `static <T> boolean replaceAll(List<T> list, T oldVal, T newVal)`：使用新值替换 List 对
     */
    @Test
    public void test2() {
        ArrayList arrayList = new ArrayList();

        arrayList.add(233);
        arrayList.add(666);
        arrayList.add(110);
        arrayList.add(110);
        arrayList.add(114);

        System.out.println(Collections.max(arrayList));

        System.out.println(Collections.min(arrayList));

        System.out.println(Collections.frequency(arrayList, 110));

        List list = Arrays.asList(new Object[arrayList.size()]);
        Collections.copy(list, arrayList);
        System.out.println(list);

        Collections.replaceAll(arrayList, 110, 120);
        System.out.println(arrayList);
    }

    /*
    - `Collection` 类提供了多个 `synchronizedXxx` 方法
    - 该方法可将指定集合包装成线程同步的集合
    - 从而可以解决多线程并发访问集合时的线程安全问题
     */
    @Test
    public void test3() {
        ArrayList arrayList = new ArrayList();
        List list = Collections.synchronizedList(arrayList);

        FutureTask futureTask = new FutureTask(() -> {
            for (int i = 0; i <= 10; i++) {
                list.add(Thread.currentThread().getName() + ": " + i);
            }

            return 0;
        });

        FutureTask futureTask1 = new FutureTask(() -> {
            for (int i = 0; i <= 10; i++) {
                list.add(Thread.currentThread().getName() + ": " + i);
            }

            return 0;
        });

        Thread thread = new Thread(futureTask);
        Thread thread1 = new Thread(futureTask1);

        thread.start();
        thread1.start();

        try {
            Object o = futureTask.get();
            Object o1 = futureTask1.get();

            System.out.println(o);
            System.out.println(o1);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println(list);
    }
}
