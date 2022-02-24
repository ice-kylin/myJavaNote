package io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
# 转换流

- `InputStreamReader`：将字节的输入流转换为字符的输入流
- `OutputStreamWriter`：将一个字符的输出流转换为字节的输出流
- 属于字符流
- 作用：提供字节流与字符流之间的转换
- 编码和解码
  - 编码：字节、字节数组 -> 字符数组、字符串
  - 解码：字符数组、字符串 -> 字节、字节数组
- 字符集
  - ASCII
    - 美国标准信息交换码
    - 用一个字节的 7 位可以表示
  - ISO8859-1
    - 拉丁码表 / 欧洲码表
    - 用一个字节的 8 位表示
  - GB2312
    - 中国的中文编码表
    - 最多两个字节编码所有字符
  - GBK
    - 中国的中文编码表升级
    - 融合了更多的中文文字符号
    - 最多两个字节编码
  - Unicode
    - 国际标准码，融合了目前人类使用的所有字符
    - 为每个字符分配唯一的字符码
    - 所有的文字都用两个字节来表示
  - UTF-8
    - 变长的编码方式
    - 可用 1 - 4 个字节来表示一个字符
 */
public class IOStreamReaderWriterTest {
    @Test
    public void testInputStreamReader() {
        InputStreamReader isr = null;
        try {
            FileInputStream fis = new FileInputStream("iotest/秋树.txt");
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

            char[] cBuf = new char[5];
            int len;
            while ((len = isr.read(cBuf)) != -1) {
                System.out.print(new String(cBuf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test1() {
        OutputStreamWriter osw = null;
        InputStreamReader isr = null;
        try {
            isr = new InputStreamReader(
                    new FileInputStream("iotest/春望.txt"), StandardCharsets.UTF_8
            );
            osw = new OutputStreamWriter(
                    new FileOutputStream("iotest/春望-gbk.txt"), "gbk"
            );

            char[] cBuf = new char[5];
            int len;
            while ((len = isr.read(cBuf)) != -1) {
                osw.write(cBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (osw != null) {
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (isr != null) {
                        isr.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
