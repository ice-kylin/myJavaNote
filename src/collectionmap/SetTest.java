package collectionmap;

import org.junit.Test;

import java.util.*;

/*
# `Set` 接口

- `Set` 接口：存储无序的、不可重复的数据（集合）
  - `HashSet`
    - 作为 `Set` 接口的主要实现类
    - 线程不安全的
    - 可以储存 `null` 值
    - `LinkedHashSet`
      - 作为 `HashSet` 的子类
      - 遍历其内部数据时可以按照添加的顺序遍历
      - 对于频繁的遍历操作，`LinkedHashSet` 效率高于 `HashSet`
  - `TreeSet`
    - 可以按照添加对象的指定属性进行排序
- `Set` 接口中没有额外定义新的方法，使用的都是 `Collection` 中声明过的方法
- 向 `Set` 中添加的数据，其所在的类一定要重写 `hashCode()` 方法和 `equals()` 方法
  - 要求：重写的 `hashCode()` 方法和 `equals()` 方法尽可能保持一致性：相等的对象必须具有相等的散列码
 */
public class SetTest {
    /*
    ## 存储无序的、不可重复的数据（集合）的理解

    - 无序性
      - 不等于随机性
      - 存储的数据在底层数据中并非按照数组索引的顺序添加，而是根据数组的哈希值决定的
    - 不可重复性
      - 保证添加的元素按照 `equals()` 方法判断时，不能返回 `true`，即相同的元素只能添加一个
     */
    @Test
    public void test1() {
        Set set = new HashSet();

        set.add(233);
        set.add(666);
        set.add("Hello");
        set.add("Hello");
        set.add("Java");

        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
    ## 以 `HashSet` 为例，添加元素的过程

    - 向 `HashSet` 添加元素 a，首先调用元素所在类的 `hashCode()` 方法，计算元素 a 的哈希值
    - 此哈希值接着通过某种算法计算出在 `HashSet` 底层数组中的存放位置（即为索引位置），判断数组此位置上是否已经有元素
      - 如果此位置没有其它元素，则元素 a 添加成功（添加成功情况 1）
      - 如果此位置上有其它元素 b（或以链表形式存在的多个元素），则比较元素 a 与元素 b 的哈希值
        - 如果哈希值不相同，则元素 a 添加成功（添加成功情况 2）
        - 如果哈希值相同，进而需要调用元素 a 所在类的 `equals()` 方法
          - `equals()` 返回 `true`，元素 a 添加成功（添加成功情况 3）
          - `equals()` 返回 `false`，元素 a 添加失败
        - 对于情况 2 和 情况 3 而言，元素 a 与已经存在指定索引位置上数据以链表的方式存储
          - JDK 7：元素 a 放到数组中，指向原来的元素
          - JDK 8：原来的元素在数组中，指向元素 a
    - `HashSet` 底层：数组 + 链表的结构
     */
    @Test
    public void test2() {
        HashSet animals = new HashSet();

        animals.add(new Animal("issac", 19));
        animals.add(new Animal("issac", 19));
        animals.add(new Animal("rabbit", 3));
        animals.add(new Animal("dog", 8));

        for (Object animal : animals) {
            System.out.println(animal);
        }
    }

    /*
    ## `LinkedHashSet`

    - 作为 `HashSet` 的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个数据和后一个数据
    - 优点：对于频繁的遍历操作，`LinkedHashSet` 效率高于 `HashSet`
     */
    @Test
    public void test3() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();

        linkedHashSet.add(233);
        linkedHashSet.add(666);
        linkedHashSet.add("Hello");
        linkedHashSet.add("Hello");
        linkedHashSet.add("Java");

        Iterator iterator = linkedHashSet.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
    ## `TreeSet`

    - 向 `TreeSet` 中添加的数据要求是相同类的对象
    - 两种排序方式
      - 自然排序（实现 `Comparable` 接口）
        - 自然排序中比较两个对象是否相同的标准为 `compareTo()` 返回 0，不再是 `equals()`
      - 定制排序
     */
    @Test
    public void test4() {
        TreeSet treeSet = new TreeSet();

        treeSet.add(233);
        treeSet.add(666);
        treeSet.add(110);

        for (Object value : treeSet) {
            System.out.println(value);
        }

        TreeSet treeSet1 = new TreeSet();

        treeSet1.add(new Animal("issac", 20));
        treeSet1.add(new Animal("issac", 19));
        treeSet1.add(new Animal("dog", 19));
        treeSet1.add(new Animal("rabbit", 1));
        treeSet1.add(new Animal("cat", 2));
        treeSet1.add(new Animal("bird", 1));
        treeSet1.add(new Animal("bird", 1));

        for (Object o : treeSet1) {
            System.out.println(o);
        }
    }

    @Test
    public void test5() {
        TreeSet animals = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Animal && o2 instanceof Animal) {
                    Animal animal1 = (Animal) o1;
                    Animal animal2 = (Animal) o2;

                    if (animal1 == animal2 || animal1.equals(animal2)) {
                        return 0;
                    } else {
                        return animal1.getName().compareTo(animal2.getName());
                    }
                } else {
                    throw new RuntimeException("传入的类型不一致：不是 Animal");
                }
            }
        });

        animals.add(new Animal("rabbit", 3));
        animals.add(new Animal("issac", 19));
        animals.add(new Animal("dog", 8));
        animals.add(new Animal("cat", 6));
        animals.add(new Animal("cat", 3));

        for (Object animal : animals) {
            System.out.println(animal);
        }
    }

    private static class Animal implements Comparable {
        private String name;
        private int age;

        public Animal() {
        }

        public Animal(String name, int age) {
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
        public String toString() {
            return "Animal{" + "name='" + name + '\'' + ", age=" + age + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Animal animal = (Animal) o;

            if (age != animal.age) return false;
            return Objects.equals(name, animal.name);
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + age;
            return result;
        }

        @Override
        public int compareTo(Object o) {
            if (o instanceof Animal) {
                Animal animal = (Animal) o;

                if (this.equals(animal)) {
                    return 0;
                } else if (this.name.equals(animal.name)) {
                    return Integer.compare(this.age, animal.age);
                } else {
                    return this.name.compareTo(animal.name);
                }
            } else {
                throw new RuntimeException("传入的类型不一致：不是 Animal");
            }
        }
    }
}
