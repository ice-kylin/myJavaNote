package reflection;

import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {
    /*
    ## `T newInstance()`

    - 调用此方法，创建对应的运行时类的对象，内部调用了运行时类的空参的构造器
    - 要想此方法正常地创建运行时类的对象，要求
      - 运行时类必须提供空参的构造器
      - 空参构造器的访问权限得够，通常设置为 `public`
    - 在 JavaBean 中要求提供一个 `public` 的空参构造器，原因
      - 便于通过反射，创建运行时类的对象
      - 便于子类继承此运行时类时，默认调用 `super()` 时，保证父类有此构造器
     */
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Person p1 = personClass.newInstance();

        System.out.println(p1);
    }

    @Test
    public void test2() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String className = null;

        switch (new Random().nextInt(2)) {
            case 0:
                className = "reflection.Animal";
                break;
            case 1:
                className = "reflection.Person";
        }

        Object o = getInstance(className);
        System.out.println(o);
    }

    public Object getInstance(String className) throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException {
        Class<?> cls = Class.forName(className);

        return cls.newInstance();
    }
}
