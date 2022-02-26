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
- 作用：用于读取或写出基本数据类型的变量或字符串
- 注意点：读取不同类型的数据的顺序要与当初写入文件时保存的数据类型的顺序一致
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

    @Test
    public void test3() {
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("iotest/data.txt")
                    )
            );

            dos.writeUTF("Hello World");
            dos.writeInt(19);
            dos.writeBoolean(true);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 将文件中储存的基本数据类型变量和字符串读取到内存中（保存到变量中）
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("iotest/data.txt")
                    )
            );

            String utf = dis.readUTF();
            int i = dis.readInt();
            boolean b = dis.readBoolean();

            System.out.println(utf);
            System.out.println(i);
            System.out.println(b);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
