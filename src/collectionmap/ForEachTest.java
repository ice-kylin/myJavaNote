package collectionmap;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/*
# 增强 for 循环（JDK 5.0 新增）

- 用于遍历集合、数组
 */
public class ForEachTest {
    /*
    格式：`for (集合元素的类型 局部变量 : 集合对象)`
     */
    @Test
    public void test1() {
        Collection c1 = new ArrayList();

        c1.add(233);
        c1.add("Hello");
        c1.add(new Date());
        c1.add("Java");

        for (Object o : c1) {
            System.out.println(o);
        }
    }

    /*
    格式：`for (数组元素的类型 局部变量 : 数组对象)`
     */
    @Test
    public void test2() {
        for (int i : new int[]{1, 2, 3, 4}) {
            System.out.println(i);
        }
    }
}
