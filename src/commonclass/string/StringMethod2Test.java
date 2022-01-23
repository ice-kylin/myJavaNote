package commonclass.string;

import org.junit.Test;

/*
# `String` 常用方法 3

- `String replace(char oldChar, char newChar)`
  - 返回一个新的字符串，它是通过用 `newChar` 替换此字符串中出现的所有 `oldChar` 得到的
- `String replace(CharSequence target, CharSequence replacement)`
  - 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
- `String replaceAll(String regex, String replacement)`
  - 使用给定的 `replacement` 替换此字符串所有匹配给定的正则表达式的子字符串
- `String replaceFirst(String regex, String replacement)`
  - 使用给定的 `replacement` 替换此字符串匹配给定的正则表达式的第一个子字符串
- `boolean matches()`：告知此字符串是否匹配给定的正则表达式
- `String[] split(String regex)`：根据给定的正则表达式的匹配拆分此字符串
- `String[] split(String regex, int limit)`：根据给定的正则表达式的匹配拆分此字符串
  - 最多不超过 `limit` 个
  - 如果超过了，剩下的全部都放到最后一个元素去
 */
public class StringMethod2Test {
    /*
    - `String replace(char oldChar, char newChar)`
      - 返回一个新的字符串，它是通过用 `newChar` 替换此字符串中出现的所有 `oldChar` 得到的
    - `String replace(CharSequence target, CharSequence replacement)`
      - 使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串
    - `String replaceAll(String regex, String replacement)`
      - 使用给定的 `replacement` 替换此字符串所有匹配给定的正则表达式的子字符串
    - `String replaceFirst(String regex, String replacement)`
      - 使用给定的 `replacement` 替换此字符串匹配给定的正则表达式的第一个子字符串
     */
    @Test
    public void test1() {
        String s1 = "HelloWorld!";

        String s2 = s1.replace('l', 'L');
        String s3 = s1.replace("World", "Java");

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
    }

    /*
    `boolean matches()`：告知此字符串是否匹配给定的正则表达式
     */
    @Test
    public void test2() {
        String s1 = "2333";
        String s2 = "HelloWorld";

        boolean b1 = s1.matches("\\d+"); // 匹配数字
        boolean b2 = s2.matches("\\d+");

        System.out.println("b1 = " + b1);
        System.out.println("b2 = " + b2);
    }

    /*
    - `String[] split(String regex)`：根据给定的正则表达式的匹配拆分此字符串
    - `String[] split(String regex, int limit)`：根据给定的正则表达式的匹配拆分此字符串
      - 最多不超过 `limit` 个
      - 如果超过了，剩下的全部都放到最后一个元素去
     */
    @Test
    public void test3() {
        String s1 = "Java|Python|C|Scala|JavaScript";

        String[] s2 = s1.split("\\|");
        String[] s3 = s1.split("\\|", 3);

        for (int i = 0; i < s2.length; i++) {
            System.out.println(i + 1 + ": " + s2[i]);
        }

        System.out.println();

        for (int i = 0; i < s3.length; i++) {
            System.out.println(i + 1 + ": " + s3[i]);
        }
    }
}
