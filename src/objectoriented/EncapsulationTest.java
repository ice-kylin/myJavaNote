package objectoriented;

/*
# 面向对象的特征一：封装和隐藏

## 问题的引入

- 当创建了一个类的对象以后，可以通过 `对象.属性` 的方式对对象的属性进行赋值
- 这里赋值操作要受到属性的数据类型和存储范围的制约，除此之外没有其它的制约条件
- 但是在实际问题中，往往需要给属性加入额外的限制条件
- 这个条件就不能在属性声明时体现
- 只能通过方法进行限制条件的添加
- 同时需要避免用户再使用 `对象.属性` 的方式对属性进行赋值
- 则需要将属性声明为私有的（private）
- 此时，针对属性就体现了封装性

## 封装性的体现

- 将类的属性（xxx）私有化（private），同时提供公共的（public）方法来获取（getXxx）和设置（setXxx）此属性的值
- 其它体现
  - 不对外暴露的私有的方法
  - 单例模式
  - ...

## 封装性的体现，需要权限修饰符来配合

- Java 规定的 4 种权限（从小到大排列）
  - private
  - 缺省
  - protected
  - public
- 4 种权限可以用来修饰类以及类的内部结构
  - 类的内部结构
    - 属性
    - 方法
    - 构造器
    - 内部类
  - 具体的
    - 4 种权限都可以用来修饰类的内部结构
    - 修饰类只能使用缺省或 public

|  修饰符   | 类内部 | 同一个包 | 不同包的子类 | 同一个工程 |
| :-------: | :----: | :------: | :----------: | :--------: |
|  private  |  Yes   |          |              |            |
| （缺省）  |  Yes   |   Yes    |              |            |
| protected |  Yes   |   Yes    |     Yes      |            |
|  public   |  Yes   |   Yes    |     Yes      |    Yes     |

## 总结

Java 提供了 4 种权限修饰符来修饰类以及类的内部结构，体现了类及类的内部结构在被调用时的可见性大小
 */
public class EncapsulationTest {
    public static void main(String[] args) {
        Animal animal = new Animal();

        animal.name = "Issac";
        animal.age = 19;
        // animal.legs = 4;
        // animal.showInfo();

        // animal.legs = -4;
        // animal.showInfo();

        animal.setLegs(2);
        animal.showInfo();

        animal.setLegs(3);
        animal.showInfo();
    }
}

class Animal {
    String name;
    int age;
    private int legs;

    // 对属性的获取
    public int getLegs() {
        return legs;
    }

    // 对属性的设置
    public void setLegs(int l) {
        if (l >= 0 && l % 2 == 0) {
            legs = l;
        } else {
            legs = 0;
        }
    }

    public void eat() {
        System.out.println("动物进食");
    }

    public void showInfo() {
        System.out.println("name = " + name + ", age = " + age + ", legs = " + legs);
    }
}
