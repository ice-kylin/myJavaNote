package objectoriented.thisinstruction;

/*
# `this` 关键字的使用

- `this` 可以用来修饰属性、方法、构造器
  - `this` 修饰属性和方法
    - `this` 理解为当前对象或当前正在创建的对象
    - 在类的方法、构造器中，可以使用 `this.属性` 或 `this.方法()` 的方式调用当前对象、正在创建的对象的属性或方法
    - 但是通常情况下都选择省略 `this.`
    - 特殊情况下如果方法、构造器的形参和类的属性同名时，我们必须显式的使用 `this.变量` 的方式表明此变量是属性而非形参
  - `this` 调用构造器
    - 在类的构造器中，可以显式的使用 `this(形参列表)` 的方式调用本类中指定的其它构造器
    - 构造器中不能通过 `this(形参列表)` 的方式调用自己
    - 如果一个类中有 n 个构造器，则最多有 n - 1 个构造器中使用了 `this(形参列表)`
    - 规定：`this(形参列表)` 必须声明在当前构造器的首行
    - 构造器内部最多只能声明一个 `this(形参列表)` 用来调用其它的构造器
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("icekylin", 19);

        System.out.println("p1.getName() = " + p1.getName());
        System.out.println("p1.getAge() = " + p1.getAge());
    }
}
