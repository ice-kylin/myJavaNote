package collectionmap;

import org.junit.Test;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/*
# `TreeMap`

- 向 `TreeMap` 中添加 key - value，要求 key 必须是由同一个类创建的对象
- 因为要按照 key 进行排序：自然排序、定制排序
 */
public class TreeMapTest {
    // 自然排序
    @Test
    public void test1() {
        TreeMap treeMap = new TreeMap();

        treeMap.put(new Animal("dog", 8), "狗");
        treeMap.put(new Animal("cat", 8), "猫");
        treeMap.put(new Animal("rabbit", 8), "兔");
        treeMap.put(new Animal("issac", 19), "姬");
        treeMap.put(new Animal("duck", 1), "鸭");

        for (Object o : treeMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;

            Object value = entry.getValue();
            Object key = entry.getKey();

            System.out.println("value: " + value + ", " + "key: " + key);
        }
    }

    // 定制排序
    @Test
    public void test2() {
        TreeMap treeMap = new TreeMap((o1, o2) -> {
            if (o1 instanceof Animal && o2 instanceof Animal) {
                if (o1 == o2) {
                    return 0;
                } else {
                    Animal animal1 = (Animal) o1;
                    Animal animal2 = (Animal) o2;

                    if (animal1.equals(animal2)) {
                        return 0;
                    } else {
                        int age = Integer.compare(animal1.getAge(), animal2.getAge());

                        if (age == 0) {
                            return animal1.getName().compareTo(animal2.getName());
                        } else {
                            return age;
                        }
                    }
                }
            } else {
                throw new IllegalArgumentException("传入的参数类型不一致");
            }
        });

        treeMap.put(new Animal("dog", 8), "狗");
        treeMap.put(new Animal("cat", 8), "猫");
        treeMap.put(new Animal("rabbit", 9), "兔");
        treeMap.put(new Animal("issac", 19), "姬");
        treeMap.put(new Animal("duck", 3), "鸭");

        for (Object o : treeMap.entrySet()) {
            Map.Entry entry = (Map.Entry) o;

            Object value = entry.getValue();
            Object key = entry.getKey();

            System.out.println("value: " + value + ", " + "key: " + key);
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

            TreeMapTest.Animal animal = (TreeMapTest.Animal) o;

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
            if (o == this) {
                return 0;
            } else {
                if (o instanceof TreeMapTest.Animal) {
                    TreeMapTest.Animal animal = (TreeMapTest.Animal) o;

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
}
