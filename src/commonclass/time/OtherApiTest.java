package commonclass.time;

/*
# 其它 API

- `ZoneId`
  - 该类中包含了所有的时区信息
    - 一个时区的 ID，如 `Asia/Shanghai`
- `ZonedDateTime`
  - 一个在 `ISO-8601` 日历系统时区的日期时间
    - 如 `2022-12-03T10:15:30+01:00 Europe/Paris`
    - 其中每个时区都对应着 ID，地区 ID 都为 `{区域}/{城市}` 的格式，例如 `Asia/Shanghai` 等
- `Clock`：使用时区提供对当前即时、日期和时间的访问的时钟
- `Duration`：用于计算两个“时间”间隔
- `Period`：用于计算两个“日期”间隔
- `TemporalAdjuster`
  - 时间校正器
  - 有时候可能需要获取例如将日期调整到“下一个工作日”等操作
- `TemporalAdjusters`
  - 该类通过静态方法（如 `firstDayOfXxx()` / `lastDayOfXxx()` / `nextXxx()`）提供了大量的常用 `TemporalAdjuster` 的实现
 */
public class OtherApiTest {
    public static void main(String[] args) {

    }
}
