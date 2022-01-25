package commonclass.time;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/*
# 日期和时间 API（JDK 8 之前）

1. `System` 类中的 `currentTimeMillis()`
2. `java.util.Date` 类和其子类 `java.sql.Date`
3. `SimpleDateFormat` 类
4. `java.util.Calender` 类
 */
public class CalendarTest {
    /*
    ## `java.util.Calender` 类

    ### 实例化

    1. 创建其子类 `java.util.GregorianCalendar` 的对象
    2. 调用其静态方法 `getInstance()`

    ### 常用方法

    - `int get(int field)`：取得主要的时间信息
      - 注意
        - 获取月份时：一月是 `0`、二月是 `1`、...、十二月是 `11`
        - 获取星期时：周日是 `1`、周一是 `2`、...、周六是 `7`
    - `void set(int field, int value)`
     */
    @Test
    public void test1() {
        Calendar c1 = Calendar.getInstance();
        System.out.println("c1.getClass() = " + c1.getClass());

        int i1 = c1.get(Calendar.DAY_OF_MONTH);
        int i2 = c1.get(Calendar.DAY_OF_WEEK);
        int i3 = c1.get(Calendar.DAY_OF_YEAR);

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);

        System.out.println();

        c1.set(Calendar.DAY_OF_MONTH, 1);

        showCalendarInfo(c1);

        System.out.println();

        c1.add(Calendar.DAY_OF_MONTH, 7);

        showCalendarInfo(c1);
    }

    private void showCalendarInfo(Calendar c1) {
        int i1;
        int i2;
        int i3;
        i1 = c1.get(Calendar.DAY_OF_MONTH);
        i2 = c1.get(Calendar.DAY_OF_WEEK);
        i3 = c1.get(Calendar.DAY_OF_YEAR);

        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }

    /*
    - `Date getTime()`：`Calender` -> `Date`
    - `void setTime(Date date)`
     */
    @Test
    public void test2() {
        Calendar c1 = Calendar.getInstance();

        Date d1 = c1.getTime();
        System.out.println("d1 = " + d1);

        c1.setTime(new Date());
        System.out.println(c1.get(Calendar.DAY_OF_MONTH));
    }
}
