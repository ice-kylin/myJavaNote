package io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
# 随机存取文件流

- 直接继承于 `Object` 类，实现了 `DateInput` 和 `DataOutput` 接口
- 既可以作为一个输入流，又可以作为一个输出流
- 如果 `RandomAccessFile` 作为输出流时
  - 写出到的文件如果不存在，则在执行过程中自动创建
  - 如果写出到的文件存在，则会对原来的文件内容进行覆盖（默认情况下从头覆盖）
- 可以通过相关的操作，实现 `RandomAccessFile` 插入数据的效果
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf2 = null;
        RandomAccessFile raf1 = null;
        try {
            raf1 = new RandomAccessFile("iotest/春望.txt", "r");
            raf2 = new RandomAccessFile("iotest/春望-copy2.txt", "rw");

            byte[] bBuf = new byte[1024];
            int len;
            while ((len = raf1.read(bBuf)) != -1) {
                raf2.write(bBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("iotest/raf.txt", "rw");

            raf.write("Java".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        RandomAccessFile raf = null;
        try {
            File file = new File("iotest/raf.txt");
            raf = new RandomAccessFile(file, "rw");
            StringBuilder copy = new StringBuilder((int) file.length());

            raf.seek(4);
            byte[] bBuf = new byte[1024];
            int len;
            while ((len = raf.read(bBuf)) != -1) {
                copy.append(new String(bBuf, 0, len));
            }

            raf.seek(4);
            raf.write("Hell".getBytes());
            raf.write(copy.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
