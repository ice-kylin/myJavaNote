package objectoriented.inherit;

/*
# 方法的重写

- 重写：子类继承父类以后，可以对父类中同名同参数的方法进行覆盖操作
- 应用：重写以后，当创建子类对象后通过子类对象调用父类中同名同参数的方法时实际执行的是子类重写父类的方法
- 重写的规定
  - 方法的声明：`权限修饰符 返回值类型 方法名(形参列表) {方法体}`
  - 约定
    - 子类中的叫重写的方法
    - 父类中的叫被重写的方法
  - 子类重写的方法的方法名和形参列表与父类被重写的方法的方法名和形参列表相同
  - 子类重写的方法的权限修饰符不小于父类被重写的方法的权限修饰符
    - 特殊情况：子类不能重写父类中声明为 `private` 权限的方法
  - 返回值类型
    - 父类中被重写的方法的返回值类型是 `void`，则子类重写的方法的返回值类型只能是 `void`
    - 父类中被重写的方法的返回值类型是 A 类型，则子类重写的方法的返回值类型可以是 A 类或 A 类的子类
    - 父类中被重写的方法的返回值类型是基本数据类型，则子类重写的方法的返回值类型必须是相同的基本数据类型
  - 子类重写的方法抛出的异常类型不大于父类被重写的方法的方法抛出的异常
  - 子类和父类中同名同参数的方法要么都声明为非 `static` 的（考虑重写），要么都声明为 `static` 的（不是重写）
 */
public class OverrideTest {
    public static void main(String[] args) {
        Person p = new Student();
        System.out.println(p.name);
    }
}

class Person {
    public String name = "人";

    private void show() {
        System.out.println("我是人");
    }
}

class Student extends Person {
    public String name = "学生";

    public void show() {
        System.out.println("我是学生");
    }
}
