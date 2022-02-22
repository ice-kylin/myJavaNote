package io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
# `FileReader`、`FileWriter`

## 流的体系结构

|   抽象基类   |      节点流      |        缓冲流        |
| :----------: | :--------------: | :------------------: |
| InputStream  | FileInputStream  | BufferedInputStream  |
| OutputStream | FileOutputStream | BufferedOutputStream |
|    Reader    |    FileReader    |    BufferedReader    |
|    Writer    |    FileWriter    |    BufferedWriter    |
 */
public class FileReaderWriterTest {
    /*
    ## `FileReader`

    ### 说明

    - `read()` 的理解
      - 返回读入的一个字符
      - 如果达到文件末尾，返回 `-1`
    - 异常地处理：为了保证流资源一定可以执行关闭操作，需要使用 try - catch - finally 处理
    - 读入的文件一定要存在，否则一定会报 `FileNotFoundException`
     */
    @Test
    public void testFileReader1() {
        // 1. 实例化 File 类对象，指明要操作的文件
        File hello = new File("hello.txt");
        FileReader helloFileReader = null;
        try {
            // 2. 提供具体的流
            helloFileReader = new FileReader(hello);
            // 3. 数据的读入
            int helloRead = helloFileReader.read(); // `read()`：返回读入的一个字符，如果达到文件末尾，返回 `-1`

            while (helloRead != -1) {
                System.out.print((char) helloRead);
                helloRead = helloFileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (helloFileReader != null) {
                    // 4. 流的关闭操作
                    helloFileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileReader2() {
        // 1. 实例化 File 类对象，指明要操作的文件
        File helloFile = new File("iotest/秋树.txt");
        StringBuilder sb = new StringBuilder();

        FileReader helloFileReader = null;
        try {
            // 2. 提供具体的流
            helloFileReader = new FileReader(helloFile);

            char[] cBuf = new char[5];
            int read = helloFileReader.read(cBuf); // 3. 数据的读入

            while (read != -1) {
                sb.append(cBuf, 0, read);
                read = helloFileReader.read(cBuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (helloFileReader != null) {
                    helloFileReader.close(); // 4. 流的关闭操作
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(sb);
    }

    /*
    ## `FileWriter`

    - 从内存中写出数据到硬盘的文件里

    ### 说明

    - 输出操作，对应的 File 可以不存在，并不会报异常
    - `File` 对应的文件
      - 如果不存在，在输出的过程中，会自动创建此文件
      - 如果存在，并且流使用的构造器是
        - `FileWriter(File file)`：对原有文件的覆盖
        - `FileWriter(File file, boolean append)`：不会对原有文件覆盖，而是在原有文件的基础上追加内容
     */
    @Test
    public void testFileWriter1() {
        // 1. 提供 `File` 类的对象，指明要写出到的文件
        File file = new File("iotest/春望.txt");

        FileWriter fileWriter = null;
        try {
            // 2. 提供 `FileWriter` 的对象，用于数据的写出
            fileWriter = new FileWriter(file);
            // 3. 写出的操作
            fileWriter.write("国破山河在，城春草木深。\n");
            fileWriter.write("感时花溅泪，恨别鸟惊心。\n");
            fileWriter.write("烽火连三月，家书抵万金。\n");
            fileWriter.write("白头搔更短，浑欲不胜簪。");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close(); // 4. 流的关闭操作
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
    ## 文本的复制

    - 不能使用字符流来处理像图片等的二进制文件
     */
    @Test
    public void test1() {
        // 1. 创建 File 类的对象，指明读入和写入的文件
        File origin = new File("iotest/春望.txt");
        File dest = new File("iotest/春望-copy.txt");

        FileWriter destWriter = null;
        FileReader originReader = null;
        try {
            // 2. 创建输入流和输出流的对象
            originReader = new FileReader(origin);
            destWriter = new FileWriter(dest);
            // 3. 数据的读入和写出操作
            char[] cBuf = new char[5];
            int read;
            while ((read = originReader.read(cBuf)) != -1) {
                destWriter.write(cBuf, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {// 4. 关闭流资源
            try {
                if (destWriter != null) {
                    destWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (originReader != null) {
                        originReader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
