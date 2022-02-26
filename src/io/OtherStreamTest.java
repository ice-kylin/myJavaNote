package io;

import org.junit.Test;

import java.io.*;

/*
# 其它流

## 标准的输入输出流

- 标准的输入输出流
  - `System.in`：标准的输入流
  - `System.out`：标准的输入流
- 重新指定输入和输出的流
  - `static void setIn(InputStream in)`
  - `static void setOut(PrintStream out)`

## 打印流

- 提供了一系列重载的 `print()` 和 `println()` 方法

## 数据流

- `DateInputStream` 和 `DateOutputStream`
- 作用：
 */
public class OtherStreamTest {
    @Test
    public void test1() throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        String line;
        do {
            System.out.print("请输入：");
            if ((line = br.readLine()) != null && !("e".equalsIgnoreCase(line.trim()) || "exit".trim().equalsIgnoreCase(line.trim()))) {
                System.out.println(line.toUpperCase());
            } else {
                break;
            }
        } while (true);
    }

    @Test
    public void test2() {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(
                    new FileOutputStream("iotest/ascii.txt"), true
            );

            System.setOut(printStream);

            for (int i = 0; i < 255; i++) {
                System.out.print((char) i);
                if (i % 25 == 0) {
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (printStream != null) {
                printStream.close();
            }
        }
    }
}
