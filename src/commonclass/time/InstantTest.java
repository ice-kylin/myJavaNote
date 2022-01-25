package commonclass.time;

import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/*
# `Instant` 类

- 类似于 `java.util.Date` 类

## 常用方法

- `static Instant now()`：获取本初子午线对应的标准时间
- `OffsetDateTime atOffset(ZoneOffset offset)`：添加时间的偏移量
- `long toEpochMilli()`
  - 获取自 1970 年 1 月 1 日 0 时 0 分 0 秒（UTC）开始的毫秒数
  - 类似于 `java.util.Date` 类的 `long getTime()` 方法
- `static Instant ofEpochMilli(long epochMilli)`
  - 类似于 `java.util.Date(long date)`
 */
public class InstantTest {
    @Test
    public void test1() {
        Instant i1 = Instant.now();
        System.out.println("i1 = " + i1);

        OffsetDateTime offsetDateTime = i1.atOffset(ZoneOffset.ofHours(8));
        System.out.println("offsetDateTime = " + offsetDateTime);

        long l1 = i1.toEpochMilli();
        System.out.println("l1 = " + l1);

        System.out.println();

        Instant i2 = Instant.ofEpochMilli(l1);
        System.out.println("i2 = " + i2);
    }
}
