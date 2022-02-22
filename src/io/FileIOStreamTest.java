package io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
# `FileInputStream`、` FileOutputStream`

- 结论
  - 对于文本文件（`.txt`、`.java`...），使用字符流处理
  - 对于非文本文件（`.jpg`、`.mp3`...），使用字节流处理
 */
public class FileIOStreamTest {
    /*
    ## `FileInputStream`
     */
    @Test
    public void testFileInputStream1() {
        // 1. 造文件
        File file = new File("iotest/春望.txt");

        FileInputStream fileInputStream = null;
        try {
            // 2. 造流
            fileInputStream = new FileInputStream(file);
            // 3. 读数据
            byte[] bBuf = new byte[5];
            int len;
            while ((len = fileInputStream.read(bBuf)) != -1) {
                System.out.println(new String(bBuf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileInputStream2() {
        // 1. 造文件
        File file = new File("iotest/春望.txt");

        FileInputStream fileInputStream = null;
        try {
            // 2. 造流
            fileInputStream = new FileInputStream(file);
            // 3. 读数据
            System.out.println(new String(fileInputStream.readAllBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭流
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    ## 图片的复制
     */
    @Test
    public void test1() {
        File origin = new File("iotest/唐可可.jpg");
        File dest = new File("iotest/唐可可-copy.jpg");

        FileOutputStream destOutputStream = null;
        FileInputStream originInputStream = null;
        try {
            originInputStream = new FileInputStream(origin);
            destOutputStream = new FileOutputStream(dest);

            byte[] bBuf = new byte[1024];
            int len;
            while ((len = originInputStream.read(bBuf)) != -1) {
                destOutputStream.write(bBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (destOutputStream != null) {
                    destOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (originInputStream != null) {
                        originInputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
