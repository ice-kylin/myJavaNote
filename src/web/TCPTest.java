package web;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {
    // 客户端
    @Test
    public void testClient() {
        BufferedOutputStream bos = null;
        Socket socket = null;
        try {
            // 1. 创建 Socket 对象，指明服务器端的 IP 和端口号
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress, 2333);
            // 2. 获取一个输入流，用于输出数据
            bos = new BufferedOutputStream(socket.getOutputStream());
            // 3. 写出数据的操作
            bos.write("我是客户端呀 ~".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4. 资源的关闭
            if (bos != null) {
                try {
                    bos.close();
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

    // 服务端
    @Test
    public void testServer() {
        BufferedReader br = null;
        Socket socket = null;
        ServerSocket ss = null;
        try {
            // 1. 创建服务端的 ServerSocket，指明自己的端口号
            ss = new ServerSocket(2333);
            // 2. 调用 accept() 表示接受来自客户端的 socket
            socket = ss.accept();

            InetAddress inetAddress = socket.getInetAddress();
            System.out.println("客户端主机名称：" + inetAddress.getHostName());
            System.out.println("客户端主机地址：" + inetAddress.getHostAddress());

            // 3. 获取输入流
            br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
            );

            // 4. 读取输入流中的数据
            char[] cBuf = new char[16];
            int len;
            while ((len = br.read(cBuf)) != -1) {
                System.out.print(new String(cBuf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭资源
            if (br != null) {
                try {
                    br.close();
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
