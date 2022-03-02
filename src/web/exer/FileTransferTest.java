package web.exer;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class FileTransferTest {
    @Test
    public void testClient() {
        InputStreamReader sisr = null;
        BufferedInputStream bis = null;
        BufferedOutputStream sbos = null;
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 2333);
            sbos = new BufferedOutputStream(socket.getOutputStream());
            bis = new BufferedInputStream(
                    new FileInputStream("webtest/唐可可.jpg")
            );
            sisr = new InputStreamReader(new BufferedInputStream(socket.getInputStream()));

            byte[] bBuf = new byte[1024];
            int len;
            while ((len = bis.read(bBuf)) != -1) {
                sbos.write(bBuf, 0, len);
            }

            socket.shutdownOutput();

            char[] cBuf = new char[64];
            while ((len = sisr.read(cBuf)) != -1) {
                System.out.print(new String(cBuf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sisr != null) {
                try {
                    sisr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sbos != null) {
                try {
                    sbos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testServer() {
        BufferedOutputStream sbos = null;
        BufferedOutputStream bos = null;
        BufferedInputStream sbis = null;
        Socket socket = null;
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(2333);
            socket = ss.accept();
            sbis = new BufferedInputStream(socket.getInputStream());
            bos = new BufferedOutputStream(
                    new FileOutputStream("webtest/唐可可-receive.jpg")
            );
            sbos = new BufferedOutputStream(socket.getOutputStream());

            byte[] bBuf = new byte[1024];
            int len;
            while ((len = sbis.read(bBuf)) != -1) {
                bos.write(bBuf, 0, len);
            }

            sbos.write("接收成功...".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sbos != null) {
                try {
                    sbos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sbis != null) {
                try {
                    sbis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
