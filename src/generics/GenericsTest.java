package generics;

import org.junit.Test;

import java.util.*;

/*
# 泛型（Generics）

- JDK 5.0 新增的特性
- 在集合中使用泛型
  - 集合或集合类在 JDK 5.0 时都修改为带泛型的结构
  - 在实例化集合时，可以指明具体的泛型类型
  - 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（如方法、构造器、属性等）使用到类的泛型的位置，都指定为实例化的泛型类型
  - 泛型的类型必须是类，不能是基本数据类型
    - 需要用到基本数据类型的位置，拿包装类替换
  - 如果实例化时没有指明泛型的类型，默认类型为 `Object` 类型
- 如何自定义泛型结构：泛型类、泛型接口、泛型方法
  - 静态方法中不能使用类的泛型
  - 异常类不能声明为泛型类
 */
public class GenericsTest {
    @Test
    public void test1() {
        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(89);
        integers.add(99);
        integers.add(65);

        for (Integer i : integers) {
            System.out.println(i);
        }

        System.out.println();

        Iterator<Integer> iterator = integers.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }
    }

    @Test
    public void test2() {
        Hashtable<String, Integer> stringIntegerHashtable = new Hashtable<>();

        stringIntegerHashtable.put("dog", 10);
        stringIntegerHashtable.put("cat", 3);
        stringIntegerHashtable.put("fish", 1);

        Set<Map.Entry<String, Integer>> entries = stringIntegerHashtable.entrySet(); // 泛型的嵌套

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
    }

    @Test
    public void test3() {
        TreeSet<Animal> animals = new TreeSet<>();
        TreeSet<Animal> animals1 = new TreeSet<>(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                if (o1 == o2) {
                    return 0;
                } else {
                    if (o1.getAge() != o2.getAge()) {
                        return Integer.compare(o1.getAge(), o2.getAge());
                    } else {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
            }
        });

        Animal a1 = new Animal("dog", 9);
        Animal a2 = new Animal("cat", 3);
        Animal a3 = new Animal("fish", 1);
        Animal a4 = new Animal("rabbit", 2);
        Animal a5 = new Animal("duck", 1);

        animals.add(a1);
        animals.add(a2);
        animals.add(a3);
        animals.add(a4);
        animals.add(a5);

        animals1.add(a1);
        animals1.add(a2);
        animals1.add(a3);
        animals1.add(a4);
        animals1.add(a5);

        for (Animal animal : animals) {
            System.out.println(animal);
        }

        System.out.println();

        for (Animal animal : animals1) {
            System.out.println(animal);
        }

    }

    /*
    - 如果定义了泛型类，实例化时没有指明类的泛型，则认为此泛型类型为 `Object` 类型
    - 要求：如果定义了类是带泛型的，建议在实例化时要指明类的泛型
    */
    @Test
    public void test4() {
        Order<String> order = new Order<>("o1", 1, "233");
        System.out.println(order);

        Order<Animal> order1 = new Order<>("dog", 2, new Animal("dog", 9));
        System.out.println(order1);
    }

    /*
    - 由于子类在继承带泛型的父类时，指明了泛型类型
    - 则实例化子类对象时，不需要指明泛型
     */
    @Test
    public void test5() {
        SubOrder<String> s1 = new SubOrder<>("s1", 1, "233");
        SubOrder1 s2 = new SubOrder1("s2", 2, "666");

        System.out.println(s1);
        System.out.println(s2);
    }

    /*
    - 泛型不同的引用不能相互赋值
     */
    @Test
    public void test6() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();

        // strings = integers;
    }

    @Test
    public void test7() {
        SubOrder<String> str = new SubOrder<>("str", 1, "233");
        ArrayList<String> strings = str.copyFromArrayToArrayList(new String[]{"233", "666"});

        System.out.println(strings);
    }

    private static class Animal implements Comparable<Animal> {
        private String name;
        private int age;

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
        public int compareTo(Animal o) {
            if (this == o) {
                return 0;
            } else {
                if (name.equals(o.name)) {
                    if (age != o.age) {
                        return Integer.compare(age, o.age);
                    } else {
                        return 0;
                    }
                } else {
                    return name.compareTo(o.name);
                }
            }
        }
    }

    private static class Order<T> {
        private final String orderName;
        private final int orderId;
        private final T orderT;

        public Order(String orderName, int orderId, T orderT) {
            this.orderName = orderName;
            this.orderId = orderId;
            this.orderT = orderT;

            // 不能使用 `new E[]`，但是可以 `T[] arr = (T[]) new Object[capacity]`
            // T[] arr = new T[10];
            T[] arr = (T[]) new Object[10];
        }

        @Override
        public String toString() {
            return "Order{" +
                    "orderName='" + orderName + '\'' +
                    ", orderId=" + orderId +
                    ", orderT=" + orderT +
                    '}';
        }
    }

    private static class SubOrder<T> extends Order<T> {
        public SubOrder(String orderName, int orderId, T orderT) {
            super(orderName, orderId, orderT);
        }

        /*
        - 泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
          - 换句话说，泛型方法所属的类是不是泛型类都没有关系
        - 泛型方法可以声明为静态的
          - 原因：泛型参数是在调用方法时确定的，并非在实例化时确定
         */
        public <E> ArrayList<E> copyFromArrayToArrayList(E[] arr) {
            return new ArrayList<>(Arrays.asList(arr));
        }
    }

    private static class SubOrder1 extends Order<String> {
        public SubOrder1(String orderName, int orderId, String orderT) {
            super(orderName, orderId, orderT);
        }
    }
}
