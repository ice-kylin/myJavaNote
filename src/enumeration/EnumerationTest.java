package enumeration;

import org.junit.Test;

/*
# 枚举类

## 枚举类的使用

- 类的对象是有限多个、确定的时，称为枚举类
- 当需要定义一组常量时，强烈建议使用枚举类
- 如果枚举类中只有一个对象，则可以作为单例模式的实现方式

## 如何定义枚举类

- 自定义枚举类（JDK 5.0 之前）
- 使用 `enum` 关键字定义枚举类（JDK 5.0 之后）
  - 定义的枚举类默认继承于 `java.lang.Enum` 类

## `Enum` 类中的常用方法

- `toString()`：返回当前枚举对象常量的名称
- `values()`
  - 返回枚举类型的对象数组
  - 该方法可以很方便的遍历所有的枚举值
- `valueOf(String objName)`
  - 返回枚举类中对象名是 `objName` 的对象
  - 可以把一个字符串转为对应的枚举类的对象
  - 要求字符串必须是枚举类对象

## 使用 `enum` 关键字定义枚举类实现接口的情况

- 实现接口，在 `enum` 类中实现抽象方法
- 让枚举类的对象分别实现接口中的抽象方法
 */
public class EnumerationTest {
    @Test
    public void test1() {
        Season[] seasons = new Season[]{
                Season.SPRING,
                Season.SUMMER,
                Season.AUTUMN,
                Season.WINTER
        };

        for (Season season : seasons) {
            System.out.println(season);
            System.out.println(season.getSeasonName());
            System.out.println(season.getSeasonDesc());
        }
    }

    @Test
    public void test2() {
        DayOfWeek[] dayOfWeeks = new DayOfWeek[]{
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY,
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY
        };

        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            System.out.println(dayOfWeek);
            System.out.println(dayOfWeek.getDayName());
            System.out.println(dayOfWeek.getDayDesc());
        }

        System.out.println(DayOfWeek.class.getSuperclass());
    }

    @Test
    public void test3() {
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();

        for (DayOfWeek dayOfWeek : dayOfWeeks) {
            System.out.println(dayOfWeek);
            dayOfWeek.show();
        }

        DayOfWeek monday = DayOfWeek.valueOf("MONDAY");
        System.out.println(monday);
    }
}

// 自定义枚举类
class Season {
    // 1. 声明对象的属性：`private final` 修饰
    private final String seasonName;
    private final String seasonDesc;

    // 2. 私有化类的构造器，并给对象属性初始化
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    // 3. 提供当前枚举类的多个对象：`public static final` 修饰
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "皎阳似火");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");

    // 其它诉求 1：获取当前对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    // 其它诉求 2：`toString()`
    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

interface Showable {
    void show();
}

enum DayOfWeek implements Showable {
    // 1. 提供当前枚举类的对象，多个对象之间用 `,` 隔开，末尾对象一 `;` 结束
    MONDAY("星期一", "MON"){
        @Override
        public void show() {
            System.out.println("今天是星期一~");
        }
    },
    TUESDAY("星期二", "TUE"){
        @Override
        public void show() {
            System.out.println("今天是星期二~");
        }
    },
    WEDNESDAY("星期三", "WED"){
        @Override
        public void show() {
            System.out.println("今天是星期三~");
        }
    },
    THURSDAY("星期四", "WED"){
        @Override
        public void show() {
            System.out.println("今天是星期四~");
        }
    },
    FRIDAY("星期五", "FRI"){
        @Override
        public void show() {
            System.out.println("今天是星期五~");
        }
    },
    SATURDAY("星期六", "SAT"){
        @Override
        public void show() {
            System.out.println("今天是星期六~");
        }
    },
    SUNDAY("星期天", "SUN"){
        @Override
        public void show() {
            System.out.println("今天是星期天~");
        }
    };

    // 2. 声明对象的属性：`private final` 修饰
    private final String dayName;
    private final String dayDesc;

    // 3. 私有化类的构造器，并给对象属性初始化
    DayOfWeek(String dayName, String dayDesc) {
        this.dayName = dayName;
        this.dayDesc = dayDesc;
    }

    public String getDayName() {
        return dayName;
    }

    public String getDayDesc() {
        return dayDesc;
    }

    @Override
    public void show() {
        System.out.println("今天是星期几~");
    }
}
