package objectoriented;

/*
# 类的结构之三：构造器（构造方法 / constructor）的使用

## 构造器的作用

1. 创建对象
2. 初始化对象的信息

## 说明

- 如果没有显式的定义类的构造器的话，则默认提供一个空参的构造器
- 定义构造器的格式：`权限修饰符 类名(形参列表) {}`
- 一个类中定义的多个构造器，彼此构成重载
- 一旦显式的定义了类的构造器之后，系统就不再提供默认的空参构造器了
- 一个类中至少会有一个构造器
 */
public class ConstructorTest {
    public static void main(String[] args) {
        Person1 person1 = new Person1();
        Person1 person2 = new Person1("Issac", 19);
    }
}

class Person1 {
    String name;
    int age;

    public Person1() {

    }

    public Person1(String n, int a) {
        name = n;
        age = a;
    }

    public void eat() {
        System.out.println("eating...");
    }
}
