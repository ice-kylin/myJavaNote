package reflection.person;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/*
# 调用运行时类的指定结构
 */
public class RTest {
    @Test
    public void testField1() throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException {
        // 创建运行时类的对象
        Class<Animal> animalClass = Animal.class;

        Animal animal = animalClass.getConstructor().newInstance();

        // 获取指定的属性
        Field species = animalClass.getField("species");

        /*
        ## 设置当前属性的值

        - `set()`
          - 参数 1：指明设置那个对象的属性
          - 参数 2：将此属性的值设置为多少
         */
        species.set(animal, "bird");

        /*
        ## 获取当前属性的值

        - `get()`：参数：获取哪个对象的当前属性值
         */
        System.out.println(species.get(animal));
    }

    /*
    ## 操作运行时类中的指定的属性
     */
    @Test
    public void testField2() throws
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException,
            NoSuchFieldException {
        // 创建运行时类的对象
        Class<?> personClass = Person.class;
        Person<?> person = (Person<?>) personClass.getConstructor().newInstance();

        // get：获取运行时类中指定变量名的属性
        Field name = personClass.getDeclaredField("name");

        // 保证当前属性是可访问的
        name.setAccessible(true);

        // 获取、设置指定对象的此属性值
        name.set(person, "Dupi");
        System.out.println(name.get(person));
    }

    /*
    ## 操作运行时类中指定的方法
     */
}
