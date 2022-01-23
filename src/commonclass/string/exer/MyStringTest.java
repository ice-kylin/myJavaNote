package commonclass.string.exer;

import org.junit.Test;

public class MyStringTest {
    @Test
    public void test1() {
        String s1 = "HelloWorld!";
        String s2 = "   Hello World!   ";
        String s3 = "   HelloWorld!";
        String s4 = "HelloWorld!   ";
        String s5 = "   ";

        System.out.println("MyString.myTrim(s1) = " + MyStrings.myTrim(s1));
        System.out.println("MyString.myTrim(s2) = " + MyStrings.myTrim(s2));
        System.out.println("MyString.myTrim(s3) = " + MyStrings.myTrim(s3));
        System.out.println("MyString.myTrim(s4) = " + MyStrings.myTrim(s4));
        System.out.println("MyString.myTrim(s5) = " + MyStrings.myTrim(s5));
    }

    @Test
    public void test2() {
        String s1 = "HelloWorld!";
        String s2 = "";

        String s3 = MyStrings.reverseString(s1);
        String s4 = MyStrings.reverseString(s2);
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);

        System.out.println();


        String s5 = MyStrings.reverseString(s1, 5);
        System.out.println("s5 = " + s5);

        System.out.println();

        String s6 = MyStrings.reverseString(s1, 5, 10);
        System.out.println("s6 = " + s6);
    }

    @Test
    public void test3() {
        int i1 = MyStrings.occurrencesOfString("ab", "abkkcadkabkebfkabkskab");
        System.out.println("i1 = " + i1);
    }
}

class MyStrings {
    // 模拟 trim() 方法，去除字符串两端的空格
    public static String myTrim(String s) {
        if (s.isEmpty() || (!s.startsWith(" ") && !s.endsWith(" "))) {
            return s;
        } else {
            int length = s.length();
            int startIndex = 0;
            int endIndex = length;
            boolean allBlank = true;

            for (int i = 0; i < length; i++) {
                if (s.charAt(i) != ' ') {
                    startIndex = i;
                    allBlank = false;
                    break;
                }
            }

            for (int i = length - 1; i >= 0 && !allBlank; i--) {
                if (s.charAt(i) != ' ') {
                    endIndex = i + 1;
                    break;
                }
            }

            return allBlank ? "" : s.substring(startIndex, endIndex);
        }
    }

    // 将一个字符串中的指定部分进行反转
    public static String reverseString(String s) {
        return reverseString(s, 0, s.length());
    }

    public static String reverseString(String s, int beginIndex) {
        return reverseString(s, beginIndex, s.length());
    }

    public static String reverseString(String s, int beginIndex, int endIndex) {
        if (s.isEmpty()) {
            return s;
        } else {
            char[] reversedChars = s.substring(beginIndex, endIndex).toCharArray();

            int length = reversedChars.length;
            char tmp;

            for (int i = 0; i < length / 2; i++) {
                tmp = reversedChars[i];
                reversedChars[i] = reversedChars[length - i - 1];
                reversedChars[length - i - 1] = tmp;
            }

            return s.substring(0, beginIndex) + new String(reversedChars) + s.substring(endIndex);
        }
    }

    // 获取一个字符串在另一个字符串中出现的次数
    public static int occurrencesOfString(String searchedString, String originalString) {
        int occurrences = 0;

        for (int i = originalString.indexOf(searchedString); i < originalString.length(); ) {
            occurrences++;

            int i1 = originalString.indexOf(searchedString, i + searchedString.length());

            if (i1 != -1) {
                i = i1;
            } else {
                break;
            }
        }

        return occurrences;
    }
}
