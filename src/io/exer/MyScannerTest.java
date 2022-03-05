package io.exer;

import org.junit.Test;

public class MyScannerTest {
    @Test
    public void testGetNextString() {
        System.out.print("输入一个字符串：");
        System.out.println(MyScanner.getNextString());
    }

    @Test
    public void testGetNextInt() {
        System.out.print("输入一个 int：");
        System.out.println(MyScanner.getNextInt());
    }

    @Test
    public void testGetNextDouble() {
        System.out.print("输入一个 double：");
        System.out.println(MyScanner.getNextDouble());
    }

    @Test
    public void testGetNextBoolean() {
        System.out.print("输入一个 boolean：");
        System.out.println(MyScanner.getNextBoolean());
    }
}
