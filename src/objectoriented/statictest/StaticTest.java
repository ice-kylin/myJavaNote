package objectoriented.statictest;

/*
# `static` 关键字

- 可以用来修饰：属性、方法、代码块、内部类
- 使用 `static` 修饰属性：静态变量（类变量）
  - 属性按照是否使用 `static` 修饰，分为
    - 实例变量
      - 创建了类的多个对象，每个对象都独立的拥有一套类中的非静态属性
      - 当修改其中一个对象中的非静态属性时，不会导致其它对象中同样的属性值的更改
    - 静态变量
      - 创建了类的多个对象，多个对象共享同一个静态变量
      - 当通过某一个对象修改静态变量时，会导致其它对象调用此静态变量时是修改过了的
  - 其它说明
    - 静态变量随着类的加载而加载，可以通过 `类.静态变量` 的方式进行调用
    - 静态变量的加载要早于对象的创建
    - 由于类只会加载一次，所以静态变量在内存中也只会存在一份（方法区的静态域中）
    - |      | 类变量 | 实例变量 |
      | ---- | ------ | -------- |
      | 类   | yes    | no       |
      | 对象 | yes    | yes      |
- 使用 `static` 修饰方法
  - 静态变量随着类的加载而加载，可以通过 `类.静态方法` 的方式进行调用
  - |      | 静态方法 | 非静态方法 |
    | ---- | -------- | ---------- |
    | 类   | yes      | no         |
    | 对象 | yes      | yes        |
  - 静态方法中只能调用静态的方法或属性
  - 非静态方法中既可以调用非静态的方法或属性，也可以调用静态的方法或属性
  - 在静态的方法内不能使用 `this`、`super` 关键字
- 开发中如何确定一个属性或方法是否要声明为 `static`
  - 属性
    - 可以被多个对象所共享的，不会随着对象的不同而不同的
    - 类中的常量也常常声明为 `static`
  - 方法
    - 操作静态属性的方法
    - 工具类中的方法习惯上声明为 `static` 的
 */
public class StaticTest {
    public static void main(String[] args) {
        Chinese c1 = new Chinese();
        c1.name = "icekylin";
        c1.age = 19;
        c1.nation = "CHN";

        Chinese c2 = new Chinese();
        c2.name = "Issac";
        c2.age = 20;

        System.out.println(c2.nation);
    }
}

class Chinese {
    static String nation;

    String name;
    int age;
}
