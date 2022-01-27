package commonclass.time;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/*
# `DateTimeFormatter` 类

- 格式化或解析日期、时间
- 类似于 `SimpleDateFormat`
 */
public class DateTimeFormatterTest {
    /*
    ## 实例化

    1. 预定义的相关格式
      - `ISO_LOCAL_DATE_TIME`
      - `ISO_LOCAL_DATE`
      - `ISO_LOCAL_TIME`
     */
    @Test
    public void test1() {
        DateTimeFormatter isoLocalDateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();

        String s1 = isoLocalDateTimeFormatter.format(now); // 格式化：日期 -> 字符串
        System.out.println("s1 = " + s1);

        TemporalAccessor parse = isoLocalDateTimeFormatter.parse("2022-07-02T07:00:00.00000");
        System.out.println(parse);
    }

    /*
    2. 本地化相关格式
      - `static DateTimeFormatter ofLocalizedDateTime(FormatStyle dateTimeStyle)`
      - `static DateTimeFormatter ofLocalizedDate(FormatStyle dateStyle)`
     */
    @Test
    public void test2() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);

        ZonedDateTime now = ZonedDateTime.now();

        String s = dateTimeFormatter.format(now);
        String s1 = dateTimeFormatter1.format(now);
        String s2 = dateTimeFormatter2.format(now);
        String s3 = dateTimeFormatter3.format(now);

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }

    @Test
    public void test3() {
        DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter dateTimeFormatter5 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatter6 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
        DateTimeFormatter dateTimeFormatter7 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

        LocalDate now1 = LocalDate.now();

        String s4 = dateTimeFormatter4.format(now1);
        String s5 = dateTimeFormatter5.format(now1);
        String s6 = dateTimeFormatter6.format(now1);
        String s7 = dateTimeFormatter7.format(now1);

        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s7);
    }

    /*
    3. 自定义的格式
     */
    @Test
    public void test4() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy '年' MM '月' dd '日' HH:mm:ss");
        System.out.println(dateTimeFormatter.format(LocalDateTime.now()));

        TemporalAccessor parse = dateTimeFormatter.parse("2022 年 01 月 31 日 08:00:00");
        System.out.println(parse);
    }
}
