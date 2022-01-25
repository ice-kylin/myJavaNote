package commonclass.time;

import org.junit.Test;

import java.util.Date;

/*
# 日期和时间 API（JDK 8 之前）

1. `System` 类中的 `currentTimeMillis()`
2. `java.util.Date` 类和其子类 `java.sql.Date`
3. `SimpleDateFormat` 类
4. `java.util.Calender` 类
 */
public class DateTest {
    /*
    `System` 类中的 `static native long currentTimeMillis()`
      - 返回当前时间与 1970 年 1 月 1 日 0 时 0 分 0 秒之间与毫秒为单位的时间差
      - 称为时间戳
     */
    @Test
    public void test1() {
        long l1 = System.currentTimeMillis();
        System.out.println("l1 = " + l1);
    }

    /*
    - `java.util.Date` 类
      - `java.sql.Date` 类

    - `java.util.Date` 类
      - 两个构造器的使用
        - `Date()`：创建一个对应当前时间的 `Date` 对象
        - `Date(long date)`：创建指定毫秒数的 `Date` 对象
      - 两个方法的使用
        - `String toString()`：显示当前的年、月、日、时、分、秒（Mon Jan 24 15:41:12 GMT 2022）
        - `long getTime()`：获取当前 `Date` 对象对应的时间戳
    - `java.sql.Date` 类
      - `java.sql.Date` 对应着数据库中的日期类型的变量
      - 如何实例化
      - 如何将 `java.util.Date` 对象转化为 `java.sql.Date` 对象
     */
    @Test
    public void test2() {
        Date date1 = new Date(); // 创建一个对应当前时间的 Date 对象
        System.out.println("date1 = " + date1);

        long l1 = date1.getTime();
        System.out.println("l1 = " + l1);

        Date date2 = new Date(System.currentTimeMillis()); // 创建指定毫秒数的 Date 对象
        System.out.println("date2 = " + date2);

        java.sql.Date date3 = new java.sql.Date(System.currentTimeMillis()); // 创建 java.sql.Date 对象
        System.out.println("date3 = " + date3);

        java.sql.Date date4 = new java.sql.Date(date1.getTime()); // 将 java.util.Date 对象转化为 java.sql.Date 对象
        System.out.println("date4 = " + date4);
    }
}
