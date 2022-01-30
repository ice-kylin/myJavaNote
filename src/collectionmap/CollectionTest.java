package collectionmap;

import org.junit.Test;

import java.util.*;

/*
# `Collection` 接口

1. `boolean add(E e)`：将元素 e 添加到集合中
2. `int size()`：获取添加元素的个数
3. `boolean addAll(Collection<? extends E> c)`：将另一个集合中的集合添加到当前集合中
4. `void clear()`：清空集合元素
5. `boolean isEmpty()`：判断当前集合是否为空
6. `boolean contains(Object o)`
  - 判断当前集合是否包含 `o`
  - 在判断时会调用 `o` 对象所在类的 `equals()` 方法
7. `boolean containsAll(Collection<?> c)`：判断形参 `c` 中的所有元素是否都存在于当前集合中
8. `boolean remove(Object o)`：从当前集合中移除 `o` 元素
9. `boolean removeAll(Collection<?> c)`：从当前集合中移除 `c` 中的所有元素（差集 `\`）
10. `boolean retainAll(Collection<?> c)`：获取当前集合和 `c` 的交集，并返回给当前集合
11. `boolean equals(Object o)`：想要返回 `true`，需要当前集合和形参集合的元素都相同
12. `int hashCode()`：返回当前对象的哈希值
13. `Object[] toArray()`：集合 -> 数组
  - 数组 -> 集合：调用 `Arrays` 类的 `static <T> List<T> asList(T... a)`

## 说明

- 向 `Collection` 接口的实现类的对象添加数据 obj 时，要求 obj 所在类要重写 `equals()` 方法
 */
public class CollectionTest {
    /*
    1. `boolean add(E e)`：将元素 e 添加到集合中
    2. `int size()`：获取添加元素的个数
    3. `boolean addAll(Collection<? extends E> c)`：将另一个集合中的集合添加到当前集合中
    4. `void clear()`：清空集合元素
    5. `boolean isEmpty()`：判断当前集合是否为空
     */
    @Test
    public void test1() {
        Collection c1 = new ArrayList();

        c1.add(233); // 自动装箱
        c1.add("Hello");
        c1.add(new Date());
        c1.add("Java");

        System.out.println("c1.size() = " + c1.size());
        System.out.println("c1 = " + c1);

        Collection c2 = new ArrayList();
        c2.add("Python");
        c2.add("JavaScript");

        c1.addAll(c2);

        System.out.println("c1.size() = " + c1.size());
        System.out.println("c1 = " + c1);

        c1.clear();

        System.out.println("c1.size() = " + c1.size());
        System.out.println("c1 = " + c1);
        System.out.println("c1.isEmpty() = " + c1.isEmpty());
    }

    /*
    6. `boolean contains(Object o)`
      - 判断当前集合是否包含 `o`
      - 在判断时会调用 `o` 对象所在类的 `equals()` 方法
    7. `boolean containsAll(Collection<?> c)`：判断形参 `c` 中的所有元素是否都存在于当前集合中
     */
    @Test
    public void test2() {
        Collection c1 = new ArrayList();

        c1.add(233);
        c1.add(666);
        c1.add(new String("HelloJava!"));
        c1.add(false);
        c1.add(new Person("Issac", 19));

        System.out.println(c1.contains(233));
        System.out.println(c1.contains("HelloJava!"));
        System.out.println(c1.contains(new Person("Issac", 19)));

        System.out.println(c1.containsAll(Arrays.asList(666, false)));
    }

    /*
    8. `boolean remove(Object o)`：从当前集合中移除 `o` 元素
    9. `boolean removeAll(Collection<?> c)`：从当前集合中移除 `c` 中的所有元素（差集 `\`）
     */
    @Test
    public void test3() {
        Collection c1 = new ArrayList();

        c1.add(233);
        c1.add(666);
        c1.add(new String("HelloJava!"));
        c1.add(false);
        c1.add(new Person("Issac", 19));
        System.out.println(c1);

        c1.remove(233);
        c1.remove("HelloJava!");
        c1.remove(new Person("Issac", 19));
        System.out.println(c1);

        c1.removeAll(Arrays.asList(666, true));
        System.out.println(c1);
    }

    /*
    10. `boolean retainAll(Collection<?> c)`：获取当前集合和 `c` 的交集，并返回给当前集合
    11. `boolean equals(Object o)`：想要返回 `true`，需要当前集合和形参集合的元素都相同
    12. `int hashCode()`：返回当前对象的哈希值
    13. `Object[] toArray()`：集合 -> 数组
      - 数组 -> 集合：调用 `Arrays` 类的 `static <T> List<T> asList(T... a)`
     */
    @Test
    public void test4() {
        Collection c1 = new ArrayList();

        c1.add(233);
        c1.add(666);
        c1.add(new String("HelloJava!"));
        c1.add(false);
        c1.add(new Person("Issac", 19));
        System.out.println(c1);

        List c2 = Arrays.asList("HelloJava!",
                new Person("Issac", 19));
        c1.retainAll(c2);
        System.out.println(c1);

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(Arrays.asList(new Person("Issac", 19),
                "HelloJava!")));

        System.out.println(c1.hashCode());

        for (Object o : c1.toArray()) {
            System.out.println(o);
        }

        List c3 = Arrays.asList(new String[]{"233", "666", "110"});
        System.out.println(c3);

        List c4 = Arrays.asList(new int[]{233, 666, 110});
        System.out.println(c4);

        List c5 = Arrays.asList(new Integer[]{233, 666, 110});
        System.out.println(c5);
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
        this.name = "无名氏";
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
