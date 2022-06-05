package newfeatures.java10;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Java10Test {
    /*
    ## 局部变量的类型推断

    - 不能使用的情况
      - 局部变量不赋值，就不能实现类型推断
      - Lambda 表达式中，左边的函数式接口不能声明为 var
      - 方法引用中，左边的函数式接口不能声明为 var
      - 数组的静态初始化中的某情况
      - 方法的返回类型
      - 方法的参数类型
      - 构造器的参数类型
      - 属性
     */
    @Test
    public void test1() {
        // 1. 声明变量时，根据所附的值，推断变量的类型
        var i = 10;
        var list = new ArrayList<>();

        System.out.println(i);
        System.out.println(list);

        // 2. 遍历操作
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        for (var o : list) {
            System.out.println(o);
        }
    }

    /*
    ## 集合中新增的 copyOf()，用于创建一个只读的集合

    - 结果一个为 true，一个为 false 的原因
      - 如果 copyOf(Collection<? extends E> coll) 的参数 coll 本身就是一个只读集合，则 copyOf() 返回值即为其本身
      - 如果参数 coll 不是一个只读集合，则 copyOf() 返回一个新的集合，这个集合是只读的
     */
    @Test
    public void test2() {
        List<String> list1 = List.of("Java", "Python", "Rust");
        List<String> copy1 = List.copyOf(list1);
        System.out.println(copy1 == list1); // true

        ArrayList<String> list2 = new ArrayList<>();
        List<String> copy2 = List.copyOf(list2);
        System.out.println(copy2 == list1); // false
    }
}
