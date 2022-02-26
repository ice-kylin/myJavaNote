package io;

import org.junit.Test;

import java.io.*;

/*
# 对象流

- `ObjectInputStream` 和 `ObjectOutputStream`
- 作用：用于存储和读取基本数据类型数据或对象的处理流
  - 可以把 Java 中的对象写入到数据源中，也能把对象从数据源中还原回来
 */
public class ObjectInputOutputStreamTest {
    /*
    ## 序列化过程

    - 将内存中 Java 对象保存到磁盘中或者通过网络传输出去
    - 使用 `ObjectOutputStream` 实现
    - 想要一个对象是可序列化的，需要满足相应的要求
    - 序列化机制
      - 对象序列化机制允许把内存中的 Java 对象转换成平台无关的二进制流
      - 从而允许把这种二进制流永久持久的保存在磁盘上，或通过网络将这种二进制流传输到另一个网络节点
      - 当其它程序获取了这种二进制流，就可以恢复成原来的 Java 对象

    ## 反序列化过程

    - 将磁盘文件中的对象还原为内存中的一个 Java 对象
    - 使用 `ObjectInputStream` 实现
     */
    @Test
    public void test1() {
        String fileName = "iotest/string.dat";
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(fileName)
                    )
            );

            oos.writeObject("Hello World");
            oos.writeObject(new Person("icekylin", 19));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(fileName)
                    )
            );

            String s = (String) ois.readObject();
            Person p = (Person) ois.readObject();

            System.out.println(s);
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    ## 要求

    - 需要实现 `Serializable` 接口
    - 当前类需要提供一个全局常量 `serialVersionUID`
    - 除了当前类需要实现 `Serializable` 接口之外，还必须保证其内部所有的属性也必须是可序列化的（默认情况下，基本数据类型可序列化）
    - `ObjectInputStream` 和 `ObjectOutputStream` 不能序列化 `static` 和 `transient` 修饰的成员变量
     */
    private static class Person implements Serializable {
        private static final long serialVersionUID = 102938475647382910L;

        private String name;
        private int age;

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
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
