package io;

import org.junit.Test;

import java.io.*;

/*
# 缓冲流
 */
public class BufferedIOStreamTest {
    @Test
    public void testBufferedRead() {
        // 1. 造文件
        File origin = new File("iotest/唐可可.jpg");
        File dest = new File("iotest/tangkeke.jpg");

        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
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
}
