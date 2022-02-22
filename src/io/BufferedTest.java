package io;

import org.junit.Test;

import java.io.*;

/*
# 缓冲流

- `BufferedInputStream`
- `BufferedOutputStream`
- `BufferedReader`
- `BufferedWriter`

- 作用：提高流的读取、写入的速度
  - 提高读写速度的原因：内部提供了一个缓存区
- 处理流，就是“套接”在已有的流的基础上
 */
public class BufferedTest {
    @Test
    public void test1() {
        // 1. 造文件
        File origin = new File("iotest/唐可可.jpg");
        File dest = new File("iotest/tangkeke.jpg");

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            /*
            2. 造流
              1. 造节点流
              2. 造缓冲流
             */
            FileInputStream fis = new FileInputStream(origin);
            FileOutputStream fos = new FileOutputStream(dest);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            // 3. 复制的细节：读取、写入
            int len;
            byte[] bBuf = new byte[1024];

            while ((len = bis.read(bBuf)) != -1) {
                bos.write(bBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /*
            4. 资源关闭

            - 要求：先关闭外层的流、再关闭内层的流
            - 说明：关闭外层流的同时，内层流也会自动地进行关闭
              - 关于内层流的关闭，可以省略
             */
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (bis != null) {
                        bis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("iotest/秋树.txt"));
            bw = new BufferedWriter(new FileWriter("iotest/秋树-copy.txt"));

            int len;
            char[] cBuf = new char[256];
            while ((len = br.read(cBuf)) != -1) {
                System.out.println(cBuf);
                bw.write(cBuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("iotest/秋树.txt"));
            bw = new BufferedWriter(new FileWriter("iotest/秋树-copy.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
