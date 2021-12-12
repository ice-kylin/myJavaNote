package objectoriented;

/*
# 类中属性的使用

## 属性（成员变量） vs. 局部变量

1. 相同点
  - 定义变量的格式：`数据类型 变量名 = 变量值;`
  - 先声明，后使用
  - 变量都有其对应的作用域
2. 不同点
  - 在类中声明的位置的不同
    - 属性：直接定义在类的一对 `{}` 内
    - 局部变量：声明在方法内、方法形参、代码块内、构造器形参、构造器内部的变量
  - 权限修饰符的不同
    - 属性：可以在声明属性时指明其权限，使用权限修饰符
      - 常用的权限修饰符
        - `private`
        - `public`
        - 缺省
        - `protected`
    - 局部变量：不可以使用权限修饰符
 */
public class UserTest {

}

class User {
    // 属性（成员变量）
    String name;
    int age;
    boolean isMale;

    public void talk(String language) { // language：形参（局部变量）
        System.out.println("使用 " + language + " 交流");
    }

    public void eat() {
        String food = "🍚"; // 声明在方法内的变量（局部变量）
        System.out.println("吃 " + food);
    }
}
