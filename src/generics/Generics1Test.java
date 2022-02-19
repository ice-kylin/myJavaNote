package generics;

import org.junit.Test;

import java.util.ArrayList;

public class Generics1Test {
    /*
    ## 泛型在继承方面的体现

    - 类 A 是类 B 的父类，`G<A> `和 `G<B>` 不具备子父类关系
      - 补充：`A<E>` 和 `B<E>` 具备子父类关系
     */
    @Test
    public void test1() {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Object> list1 = new ArrayList<>();

        // list1 = list;
    }

    /*
    ## 通配符的使用

    - 类 A 是类 B 的父类，`G<A>` 和 `G<B>` 不具备子父类关系，二者共同的父类是 `G<?>`
     */
    @Test
    public void test2() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();

        strings.add("233");
        strings.add("666");

        ArrayList<?> arrayList;
        arrayList = objects;
        arrayList = strings;

        // 添加：不能向其内部添加数据（除了 `null` 之外）
        arrayList.add(null);
        show(arrayList);
    }

    public void show(ArrayList<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
