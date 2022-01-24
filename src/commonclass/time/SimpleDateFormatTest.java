package commonclass.time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
# 日期和时间 API（JDK 8 之前）

1. `System` 类中的 `currentTimeMillis()`
2. `java.util.Date` 类和其子类 `java.sql.Date`
3. `SimpleDateFormat` 类
4. `Calender` 类
 */
public class SimpleDateFormatTest {
    /*
    ## `SimpleDateFormat` 类

    - `SimpleDateFormat` 类是对日期 `Date` 类的格式化和解析
    - 两个操作
      1. 格式化：日期 -> 字符串
      2. 解析：字符串 -> 日期
        - 要求字符串必须是符合 `SimpleDateFormat` 识别的格式（通过构造器参数体现）
        - 否则抛出异常
    - `SimpleDateFormat` 的实例化
     */
    @Test
    public void test1() throws ParseException {
        SimpleDateFormat sdf;
        sdf = new SimpleDateFormat(); // 实例化 SimpleDateFormat

        Date d1 = new Date();
        System.out.println("d1 = " + d1);
        String f1 = sdf.format(d1); // 格式化：日期 -> 字符串
        System.out.println("f1 = " + f1);

        String s1 = "2022/7/2 下午10:13";
        Date d2 = sdf.parse(s1); // 解析：字符串 -> 日期
        System.out.println("d2 = " + d2);
    }

    /*
    按照指定的方式格式化和解析：调用带参数的构造器
     */
    @Test
    public void test2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy '年' MM '月' dd '日' HH:mm:ss EEE");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d1 = new Date();
        String f1 = sdf.format(d1); // 格式化：日期 -> 字符串
        String f2 = sdf1.format(d1);
        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);

        System.out.println();

        Date d2 = sdf.parse(f1); // 解析：字符串 -> 日期
        System.out.println("d2 = " + d2);
    }
}
