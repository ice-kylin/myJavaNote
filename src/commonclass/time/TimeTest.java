package commonclass.time;

import org.junit.Test;

import java.time.*;

/*
# 日期和时间 API（JDK 8 之后）

## 新日期时间 API 出现的背景

- 可变性：像日期或时间这样的类应该是不可变的
- 偏移性：`Date` 中的年份是从 `1900` 开始的，而月份都从 `0` 开始
- 格式化：格式化只对 `Date` 有用，`Calendar` 则不行
- 此外，它们也不是线程安全的，不能处理闰秒等
 */
public class TimeTest {
    /*
    ## `localDate`、`localTime`、`localDateTime` 的使用

    - 说明：`localDateTime` 相较于 `localDate` 和 `localTime` 使用频率高一些
    - 类似于 `Calendar`

    ### 常用方法

    - `now()`：获取当前的日期、时间、日期 + 时间
     */
    @Test
    public void test1() {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }

    /*
    - `of()`：设置指定的年、月、日、时、分、秒，没有偏移量
     */
    @Test
    public void test2() {
        LocalDateTime ldt = LocalDateTime.of(2022, 7, 2, 7, 0, 0);

        System.out.println(ldt);
    }

    /*
    - `getXxx()`：获取相关的属性
     */
    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.now();

        int dayOfMonth = localDateTime.getDayOfMonth();
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        int dayOfYear = localDateTime.getDayOfYear();
        Month month = localDateTime.getMonth();
        int monthValue = localDateTime.getMonthValue();

        System.out.println("dayOfMonth = " + dayOfMonth);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("dayOfYear = " + dayOfYear);
        System.out.println("month = " + month);
        System.out.println("monthValue = " + monthValue);
    }

    /*
    - `withXxx()`
      - 设置相关的属性
      - 体现不可变性
     */
    @Test
    public void test4() {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt1 = ldt.withDayOfYear(233);

        System.out.println("ldt = " + ldt);
        System.out.println("ldt1 = " + ldt1);
    }

    /*
    - `plusXxx`
    - `minusXxx`
     */
    @Test
    public void test5() {
        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime ldt1 = ldt.plusMonths(3L);
        LocalDateTime ldt2 = ldt.minusYears(1);

        System.out.println("ldt = " + ldt);
        System.out.println("ldt1 = " + ldt1);
        System.out.println("ldt2 = " + ldt2);
    }
}
