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
}
